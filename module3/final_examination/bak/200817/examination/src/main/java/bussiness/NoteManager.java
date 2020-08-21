package bussiness;

import common.BaseCRUD;
import common.Paging;
import model.Note;
import model.NoteDTO;
import java.util.List;

public interface NoteManager extends BaseCRUD<Note> {
    List<NoteDTO> getAllDTO();

    List<NoteDTO> getAllDTOWithPaging(Paging paging);

    List<NoteDTO> searchDTO(String by, String val);

    List<NoteDTO> searchDTOWithPaging(String by, String val, Paging paging);
}
