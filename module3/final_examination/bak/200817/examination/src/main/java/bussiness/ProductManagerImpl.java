package bussiness;

import common.Paging;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;
import model.ProductDTO;

import java.util.List;
import java.util.Optional;

public class ProductManagerImpl implements ProductManager {
    ProductDAO productDAO= new ProductDAOImpl();
    @Override
    public List<ProductDTO> getAllDTO() {
        return productDAO.getAllDTO();
    }

    @Override
    public List<ProductDTO> getAllDTOWithPaging(Paging paging) {
        return productDAO.getAllDTOWithPaging(paging);
    }

    @Override
    public List<ProductDTO> searchDTO(String by, String val) {
        return productDAO.searchDTO(by,val);
    }

    @Override
    public List<ProductDTO> searchDTOWithPaging(String by, String val, Paging paging) {
        return productDAO.searchDTOWithPaging(by,val,paging);
    }

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
        return productDAO.save(product);
    }

    @Override
    public int update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public int delete(String ids) {
        return productDAO.delete(ids);
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
}
