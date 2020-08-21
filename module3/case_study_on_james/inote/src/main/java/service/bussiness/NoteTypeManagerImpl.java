package service.bussiness;

import common.BaseCRUD;
import common.Paging;
import model.NoteType;
import java.util.List;
import java.util.Optional;

public class NoteTypeManagerImpl implements NoteTypeManager {
    private BaseCRUD<NoteType> inote_type;

    public NoteTypeManagerImpl(BaseCRUD<NoteType> inote_type) {
        this.inote_type = inote_type;
    }

    @Override
    public Optional<NoteType> get(int id) {
        return inote_type.get(id);
    }

    @Override
    public List<NoteType> getAll() {
        return inote_type.getAll();
    }

    @Override
    public List<NoteType> getAllWithPaging(Paging paging) {
        return inote_type.getAllWithPaging(paging);
    }

    @Override
    public void save(NoteType noteType) {
        inote_type.save(noteType);
    }

    @Override
    public void update(NoteType noteType) {
        inote_type.update(noteType);
    }

    @Override
    public void delete(String ids) {
        inote_type.delete(ids);
    }

    @Override
    public void deleteCascade(String ids) {
        inote_type.deleteCascade(ids);
    }

    @Override
    public List<NoteType> search(String by, String value) {
        return inote_type.search(by,value);
    }

    @Override
    public List<NoteType> searchWithPaging(String by, String val, Paging paging) {
        return inote_type.searchWithPaging(by,val,paging);
    }
}
