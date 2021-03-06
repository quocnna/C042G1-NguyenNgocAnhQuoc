package bussiness;

import common.Paging;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import model.Note;
import model.NoteDTO;

import java.util.List;
import java.util.Optional;

public class NoteManagerImpl implements NoteManager {
    NoteDAO noteDAO= new NoteDAOImpl();
    @Override
    public List<NoteDTO> getAllDTO() {
        return noteDAO.getAllDTO();
    }

    @Override
    public List<NoteDTO> getAllDTOWithPaging(Paging paging) {
        return noteDAO.getAllDTOWithPaging(paging);
    }

    @Override
    public List<NoteDTO> searchDTO(String by, String val) {
        return noteDAO.searchDTO(by,val);
    }

    @Override
    public List<NoteDTO> searchDTOWithPaging(String by, String val, Paging paging) {
        return noteDAO.searchDTOWithPaging(by,val,paging);
    }

    @Override
    public Optional<Note> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Note> getAll() {
        return null;
    }

    @Override
    public List<Note> getAllWithPaging(Paging paging) {
        return null;
    }

    @Override
    public int save(Note note) {
        return noteDAO.save(note);
    }

    @Override
    public int update(Note note) {
        return noteDAO.update(note);
    }

    @Override
    public int delete(String ids) {
        return noteDAO.delete(ids);
    }

    @Override
    public int deleteCascade(String ids) {
        return 0;
    }

    @Override
    public List<Note> search(String by, String val) {
        return null;
    }

    @Override
    public List<Note> searchWithPaging(String by, String val, Paging paging) {
        return null;
    }
}
