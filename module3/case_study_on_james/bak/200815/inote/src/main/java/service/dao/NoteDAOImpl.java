package service.dao;

import common.Paging;
import model.Note;
import model.NoteDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NoteDAOImpl implements NoteDAO {
    private final String SELECT_NOTEDTO = "select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id";
    private final String SELECT_ALL_NOTEDTO_PAGING = "select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id order by n.?fie ?dir limit ?lim offset ?off";
    private final String DELETE_NOTE = "delete from note where id in (?val)";
    private final String INSET_NOTE = "insert into note (title, content, note_type_id) values (?,?,?)";
    private final String UPDATE_NOTE = "update note set title=?, content=?, note_type_id=? where id=?";
    private final String SEARCH_NOTEDTO = "select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id where n.?by regexp binary '?val'";
    private final String SEARCH_NOTEDTO_ALL = "select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id where n.title regexp binary '?val' or n.content regexp binary '?val' or nt.name regexp binary '?val'";
    private final String SEARCH_NOTEDTO_PAGING = "select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id where n.?by regexp binary '?val' order by n.?fie ?dir limit ?lim offset ?off";
    private final String SEARCH_NOTEDTO_PAGING_ALL = "select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id where n.title regexp binary '?val' or n.content regexp binary '?val' or nt.name regexp binary '?val' order by n.?fie ?dir limit ?lim offset ?off";

    @Override
    public List<NoteDTO> getAllDTO() {
        List<NoteDTO> res = new ArrayList<>();
        try {
            PreparedStatement pst = Configuration.getConnection().prepareStatement(SELECT_NOTEDTO);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                int note_type_id = rs.getInt(4);
                String name = rs.getString(5);
                res.add(new NoteDTO(id, title, content, note_type_id, name));
            }
        } catch (SQLException e) {

        }
        return res;
    }

    @Override
    public List<NoteDTO> getAllDTOWithPaging(Paging paging) {
        int offset = (paging.getCurrentPage() - 1) * paging.getPageSizeItems();
        List<NoteDTO> res = new ArrayList<>();
        try {
            Statement st = Configuration.getConnection().createStatement();
            String query = SELECT_ALL_NOTEDTO_PAGING.replace("?fie", paging.getSortField()).replace("?dir", paging.getSortDir());
            query = query.replace("?lim", Integer.toString(paging.getPageSizeItems())).replace("?off", Integer.toString(offset));
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                int note_type_id = rs.getInt(4);
                String name = rs.getString(5);
                res.add(new NoteDTO(id, title, content, note_type_id, name));
            }

            int totalItems = getAllDTO().size();
            int totalPages = (int) Math.ceil((double) totalItems / paging.getPageSizeItems());
            paging.setTotalItems(totalItems);
            paging.setTotalPages(totalPages);
            paging.setTotalItemsPage(res.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<NoteDTO> searchDTO(String by, String val) {
        List<NoteDTO> res = new ArrayList<>();
        try {
            Statement st = Configuration.getConnection().createStatement();
            String query;
            if ("Note Type".equals(by))
                query = SEARCH_NOTEDTO.replace("n.?by", "nt.name").replace("?val", val);
            else
                query = "all".equals(by) ? SEARCH_NOTEDTO_ALL.replace("?val", val) : SEARCH_NOTEDTO.replace("?by", by).replace("?val", val);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                int note_type_id = rs.getInt(4);
                String name = rs.getString(5);
                res.add(new NoteDTO(id, title, content, note_type_id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<NoteDTO> searchDTOWithPaging(String by, String val, Paging paging) {
        int offset = (paging.getCurrentPage() - 1) * paging.getPageSizeItems();
        List<NoteDTO> res = new ArrayList<>();
        try {
            Statement st = Configuration.getConnection().createStatement();
            String query;
            if ("Note Type".equals(by))
                query = SEARCH_NOTEDTO_PAGING.replace("n.?by", "nt.name").replace("?val", val);
            else
                query = "all".equals(by) ? SEARCH_NOTEDTO_PAGING_ALL.replace("?val", val) : SEARCH_NOTEDTO_PAGING.replace("?by", by).replace("?val", val);
            query = query.replace("?fie", paging.getSortField()).replace("?dir", paging.getSortDir());
            query = query.replace("?lim", Integer.toString(paging.getPageSizeItems())).replace("?off", Integer.toString(offset));
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                int note_type_id = rs.getInt(4);
                String name = rs.getString(5);
                res.add(new NoteDTO(id, title, content, note_type_id, name));
            }

            int totalItems = searchDTO(by, val).size();
            int totalPages = (int) Math.ceil((double) totalItems / paging.getPageSizeItems());
            paging.setTotalItems(totalItems);
            paging.setTotalPages(totalPages);
            paging.setTotalItemsPage(res.size());
            paging.setSearchBy(by);
            paging.setSearchVal(val);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
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
    public void save(Note note) {
        try {
            PreparedStatement pst = Configuration.getConnection().prepareStatement(INSET_NOTE);
            pst.setString(1, note.getTitle());
            pst.setString(2, note.getContent());
            pst.setInt(3, note.getNote_type_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Note note) {
        try {
            PreparedStatement pst = Configuration.getConnection().prepareStatement(UPDATE_NOTE);
            pst.setString(1, note.getTitle());
            pst.setString(2, note.getContent());
            pst.setInt(3, note.getNote_type_id());
            pst.setInt(4, note.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String ids) {
        try {
            Statement st = Configuration.getConnection().createStatement();
            st.executeUpdate(DELETE_NOTE.replace("?val", ids));
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
