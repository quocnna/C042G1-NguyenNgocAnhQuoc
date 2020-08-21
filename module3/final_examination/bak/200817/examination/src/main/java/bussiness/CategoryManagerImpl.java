package bussiness;

import common.Paging;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import model.Category;

import java.util.List;
import java.util.Optional;

public class CategoryManagerImpl implements CategoryManager {
    CategoryDAO categoryDAO= new CategoryDAOImpl();
    @Override
    public Optional<Category> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
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
}
