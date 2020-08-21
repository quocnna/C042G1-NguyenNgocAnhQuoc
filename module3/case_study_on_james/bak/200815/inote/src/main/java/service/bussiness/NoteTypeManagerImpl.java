package service.bussiness;

import common.Paging;
import model.NoteType;
import service.dao.NoteTypeDAO;
import service.dao.NoteTypeDAOImpl;

import java.util.List;
import java.util.Optional;

public class NoteTypeManagerImpl implements NoteTypeManager {
    NoteTypeDAO noteTypeDAO= new NoteTypeDAOImpl();
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
    public void save(NoteType noteType) {
        noteTypeDAO.save(noteType);
    }

    @Override
    public void update(NoteType noteType) {
        noteTypeDAO.update(noteType);
    }

    @Override
    public void delete(String ids) {
        noteTypeDAO.delete(ids);
    }

    @Override
    public void deleteCascade(String ids) {
        noteTypeDAO.deleteCascade(ids);
    }

    @Override
    public List<NoteType> search(String by, String value) {
        return noteTypeDAO.search(by,value);
    }

    @Override
    public List<NoteType> searchWithPaging(String by, String val, Paging paging) {
        return noteTypeDAO.searchWithPaging(by,val,paging);
    }
}
