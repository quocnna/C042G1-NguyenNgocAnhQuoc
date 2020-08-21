package dao;

import common.Paging;
import model.Product;
import model.ProductDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {
    private final String INSET_PRODUCT = "insert into product (name, price, quantity, color, category_id) values (?,?,?,?,?)";
    private final String UPDATE_PRODUCT = "update product set name=?, price=?, quantity=?, color=?, category_id=? where id=?";
    private final String DELETE_PRODUCT = "delete from product where id in (?val)";
    private final String SELECT_PRODUCTDTO = "select n.id, n.name, n.price, n.quantity, n.color, nt.id, nt.name from product n join category nt on n.category_id= nt.id";
    private final String SELECT_ALL_PRODUCTDTO_PAGING = "select n.id, n.name, n.price, n.quantity, n.color, nt.id, nt.name from product n join category nt on n.category_id= nt.id order by n.?fie ?dir limit ?lim offset ?off";
    private final String SEARCH_PRODUCTDTO = "select n.id, n.name, n.price, n.quantity, n.color, nt.id, nt.name from product n join category nt on n.category_id= nt.id where n.?by regexp binary '?val'";
    private final String SEARCH_PRODUCTDTO_ALL = "select n.id, n.name, n.price, n.quantity, n.color, nt.id, nt.name from product n join category nt on n.category_id= nt.id where n.name regexp binary '?val' or n.price regexp binary '?val' or n.quantity regexp binary '?val' or n.color regexp binary '?val' or nt.name regexp binary '?val'";
    private final String SEARCH_PRODUCTDTO_PAGING = "select n.id, n.name, n.price, n.quantity, n.color, nt.id, nt.name from product n join category nt on n.category_id= nt.id where n.?by regexp binary '?val' order by n.?fie ?dir limit ?lim offset ?off";
    private final String SEARCH_PRODUCTDTO_PAGING_ALL = "select n.id, n.name, n.price, n.quantity, n.color, nt.id, nt.name from product n join category nt on n.category_id= nt.id where n.name regexp binary '?val' or n.price regexp binary '?val' or n.quantity regexp binary '?val' or n.color regexp binary '?val' or nt.name regexp binary '?val' order by n.?fie ?dir limit ?lim offset ?off";
    @Override
    public Optional<Product> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getAllWithPaging(Paging paging) {
        return null;
    }

    @Override
    public int save(Product product) {
        try {
            PreparedStatement pst = ConfigurationDB.getConnection().prepareStatement(INSET_PRODUCT);
            pst.setString(1, product.getName());
            pst.setDouble(2, product.getPrice());
            pst.setInt(3,product.getQuantity());
            pst.setString(4,product.getColor());
            pst.setInt(5, product.getCategory_id());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Product product) {
        try {
            PreparedStatement pst = ConfigurationDB.getConnection().prepareStatement(UPDATE_PRODUCT);
            pst.setString(1, product.getName());
            pst.setDouble(2, product.getPrice());
            pst.setInt(3,product.getQuantity());
            pst.setString(4,product.getColor());
            pst.setInt(5, product.getCategory_id());
            pst.setInt(6, product.getId());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String ids) {
        try {
            Statement st = ConfigurationDB.getConnection().createStatement();
            return st.executeUpdate(DELETE_PRODUCT.replace("?val", ids));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteCascade(String ids) {
        return 0;
    }

    @Override
    public List<Product> search(String by, String val) {
        return null;
    }

    @Override
    public List<Product> searchWithPaging(String by, String val, Paging paging) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllDTO() {
        try {
            PreparedStatement pst = ConfigurationDB.getConnection().prepareStatement(SELECT_PRODUCTDTO);
            ResultSet rs = pst.executeQuery();
            return getListFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<ProductDTO> getAllDTOWithPaging(Paging paging) {
        int offset = (paging.getCurrentPage() - 1) * paging.getPageSizeItems();
        List<ProductDTO> res = new ArrayList<>();
        try {
            Statement st = ConfigurationDB.getConnection().createStatement();
            String query = SELECT_ALL_PRODUCTDTO_PAGING.replace("?fie", paging.getSortField()).replace("?dir", paging.getSortDir());
            query = query.replace("?lim", Integer.toString(paging.getPageSizeItems())).replace("?off", Integer.toString(offset));
            ResultSet rs = st.executeQuery(query);
            res = getListFromResultSet(rs);

            paging.setPaging(getAllDTO().size(), res.size(), null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<ProductDTO> searchDTO(String by, String val) {
        try {
            Statement st = ConfigurationDB.getConnection().createStatement();
            String query;
            if ("Category".equals(by))
                query = SEARCH_PRODUCTDTO.replace("n.?by", "nt.name").replace("?val", val);
            else
                query = "all".equals(by) ? SEARCH_PRODUCTDTO_ALL.replace("?val", val) : SEARCH_PRODUCTDTO.replace("?by", by).replace("?val", val);
            ResultSet rs = st.executeQuery(query);
            return getListFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<ProductDTO> searchDTOWithPaging(String by, String val, Paging paging) {
        int offset = (paging.getCurrentPage() - 1) * paging.getPageSizeItems();
        List<ProductDTO> res = new ArrayList<>();
        try {
            Statement st = ConfigurationDB.getConnection().createStatement();
            String query;
            if ("Category".equals(by))
                query = SEARCH_PRODUCTDTO_PAGING.replace("n.?by", "nt.name").replace("?val", val);
            else
                query = "all".equals(by) ? SEARCH_PRODUCTDTO_PAGING_ALL.replace("?val", val) : SEARCH_PRODUCTDTO_PAGING.replace("?by", by).replace("?val", val);
            query = query.replace("?fie", paging.getSortField()).replace("?dir", paging.getSortDir());
            query = query.replace("?lim", Integer.toString(paging.getPageSizeItems())).replace("?off", Integer.toString(offset));
            ResultSet rs = st.executeQuery(query);
            res = getListFromResultSet(rs);

            paging.setPaging(searchDTO(by, val).size(), res.size(), by, val);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    private List<ProductDTO> getListFromResultSet(ResultSet rs) {
        List<ProductDTO> res = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int quantity= rs.getInt(4);
                String color= rs.getString(5);
                int category_id = rs.getInt(6);
                String category_name = rs.getString(7);
                res.add(new ProductDTO(id, name, price, quantity, color, category_id, category_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
