package bussiness;

import common.Paging;
import dao.NoteTypeDAO;
import dao.NoteTypeDAOImpl;
import model.NoteType;
import java.util.List;
import java.util.Optional;

public class NoteTypeManagerImpl implements NoteTypeManager {
    private NoteTypeDAO noteTypeDAO= new NoteTypeDAOImpl();
    @Override
    public Optional<NoteType> get(int id) {
        return noteTypeDAO.get(id);
    }

    @Override
    public List<NoteType> getAll() {
        return noteTypeDAO.getAll();
    }

    @Override
    public List<NoteType> getAllWithPaging(Paging paging) {
        return noteTypeDAO.getAllWithPaging(paging);
    }

    @Override
    public int save(NoteType noteType) {
        return noteTypeDAO.save(noteType);
    }

    @Override
    public int update(NoteType noteType) {
        return noteTypeDAO.update(noteType);
    }

    @Override
    public int delete(String ids) {
        return noteTypeDAO.delete(ids);
    }

    @Override
    public int deleteCascade(String ids) {
        return noteTypeDAO.deleteCascade(ids);
    }

    @Override
    public List<NoteType> search(String by, String val) {
        return noteTypeDAO.search(by,val);
    }

    @Override
    public List<NoteType> searchWithPaging(String by, String val, Paging paging) {
        return noteTypeDAO.searchWithPaging(by,val,paging);
    }
}
