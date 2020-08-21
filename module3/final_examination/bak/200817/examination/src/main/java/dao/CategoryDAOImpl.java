package dao;

import common.Paging;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CategoryDAOImpl implements CategoryDAO {
    private final String SELECT_ALL_CATEGORY= "select id, name from category";
    @Override
    public Optional<Category> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        try {
            PreparedStatement pst = ConfigurationDB.getConnection().prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet rs = pst.executeQuery();
            return getListFromResultSet(rs);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Category> getAllWithPaging(Paging paging) {
        return null;
    }

    @Override
    public int save(Category category) {
        return 0;
    }

    @Override
    public int update(Category category) {
        return 0;
    }

    @Override
    public int delete(String ids) {
        return 0;
    }

    @Override
    public int deleteCascade(String ids) {
        return 0;
    }

    @Override
    public List<Category> search(String by, String val) {
        return null;
    }

    @Override
    public List<Category> searchWithPaging(String by, String val, Paging paging) {
        return null;
    }

    private List<Category> getListFromResultSet(ResultSet rs){
        List<Category> res= new ArrayList<>();
        try{
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                res.add(new Category(id, name));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }
}
