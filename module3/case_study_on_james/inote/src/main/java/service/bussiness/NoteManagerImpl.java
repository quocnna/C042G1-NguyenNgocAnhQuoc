package service.bussiness;

import common.BaseCRUD;
import common.Paging;
import model.Note;
import model.NoteDTO;
import service.dao.NoteDAO;
import service.dao.NoteDAOImpl;
import java.util.List;
import java.util.Optional;

public class NoteManagerImpl implements NoteManager {
    private BaseCRUD<Note> inote;
    public NoteManagerImpl(BaseCRUD<Note> inote) {
        this.inote = inote;
    }

   // NoteDAO noteDAO= new NoteDAOImpl();
//    @Override
//    public List<NoteDTO> getAllDTO() {
//        return noteDAO.getAllDTO();
//    }
//
//    @Override
//    public List<NoteDTO> getAllDTOWithPaging(Paging paging) {
//        return noteDAO.getAllDTOWithPaging(paging);
//    }
//
//    @Override
//    public List<NoteDTO> searchDTO(String by, String val) {
//        return noteDAO.searchDTO(by,val);
//    }
//
//    @Override
//    public List<NoteDTO> searchDTOWithPaging(String by, String val, Paging paging) {
//        return noteDAO.searchDTOWithPaging(by,val,paging);
//    }

    @Override
    public Optional<Note> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Note> getAll() {
        return inote.getAll();
    }

    @Override
    public List<Note> getAllWithPaging(Paging paging) {
        return inote.getAllWithPaging(paging);
    }

    @Override
    public void save(Note note) {
        inote.save(note);
    }

    @Override
    public void update(Note note) {
        inote.update(note);
    }

    @Override
    public void delete(String ids) {
        inote.delete(ids);
    }

    @Override
    public void deleteCascade(String ids) {

    }

    @Override
    public List<Note> search(String by, String val) {
        return null;
    }

    @Override
    public List<Note> searchWithPaging(String by, String value, Paging paging) {
        return null;
    }
}
