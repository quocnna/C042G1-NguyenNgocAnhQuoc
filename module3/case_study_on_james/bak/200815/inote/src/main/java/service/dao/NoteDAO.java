package service.dao;

import common.Paging;
import model.Note;
import model.NoteDTO;
import java.util.List;

public interface NoteDAO extends BaseDAO<Note> {
        List<NoteDTO> getAllDTO();
        List<NoteDTO> getAllDTOWithPaging(Paging paging);
        List<NoteDTO> searchDTO(String by, String val);
        List<NoteDTO> searchDTOWithPaging(String by, String val, Paging paging);
}
