package service.dao;

import common.Paging;
import model.NoteType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NoteTypeDAOImpl implements NoteTypeDAO {
    private final String SELECT_ALL_NOTE_TYPE= "select id, name, description from note_type";
    private final String SELECT_ALL_NOTE_TYPE_PAGING= "select id, name, description from note_type order by ? ? limit ? offset ?";
    private final String INSERT_NOTE_TYPE = "insert into note_type (name, description) values (?, ?)";
    private final String UPDATE_NOTE_TYPE= "update note_type set name=?, description= ? where id=?";
    private final String DELETE_NOTE_TYPE= "delete from note_type where id in (?val)";
    private final String SELECT_NOTE_TYPE= "select id, name, description from note_type where id=?";
    private final String SEARCH_NOTE_TYPE= "select id, name, description from note_type where ?by regexp binary '?val'";
    private final String SEARCH_NOTE_TYPE_ALL= "select id, name, description from note_type where name regexp binary '?val' or description regexp binary '?val'";
    private final String SEARCH_NOTE_TYPE_PAGING= "select id, name, description from note_type where ?by regexp binary '?val' order by ?fie ?dir limit ?lim offset ?off";
    private final String SEARCH_NOTE_TYPE_PAGING_ALL= "select id, name, description from note_type where name regexp binary '?val' or description regexp binary '?val' order by ?fie ?dir limit ?lim offset ?off";
    @Override
    public Optional<NoteType> get(int id) {
        NoteType res=null;
        try {
            PreparedStatement pst = Configuration.getConnection().prepareStatement(SELECT_NOTE_TYPE);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                res = new NoteType(id, name, description);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(res);
    }

    @Override
    public List<NoteType> getAll() {
        List<NoteType> res= new ArrayList<>();
        try {
            PreparedStatement pst = Configuration.getConnection().prepareStatement(SELECT_ALL_NOTE_TYPE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                res.add(new NoteType(id, name, description));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void save(NoteType noteType) {
        try {
            PreparedStatement pst= Configuration.getConnection().prepareStatement(INSERT_NOTE_TYPE);
            pst.setString(1,noteType.getName());
            pst.setString(2,noteType.getDescription());
            pst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(NoteType noteType) {
        try {
            PreparedStatement pst= Configuration.getConnection().prepareStatement(UPDATE_NOTE_TYPE);
            pst.setString(1,noteType.getName());
            pst.setString(2,noteType.getDescription());
            pst.setInt(3,noteType.getId());
            pst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String ids) {
        try {
            Statement st = Configuration.getConnection().createStatement();
            st.executeUpdate(DELETE_NOTE_TYPE.replace("?val",ids));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCascade(String ids) {
        try {
            String call_sp = "{ call delete_cascade(?) }";
            CallableStatement cst = Configuration.getConnection().prepareCall(call_sp);
            cst.setString(1,DELETE_NOTE_TYPE.replace("?val",ids));
            cst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<NoteType> search(String by, String val) {
        List<NoteType> res= new ArrayList<>();
        try {
            Statement st= Configuration.getConnection().createStatement();
            String query = "all".equals(by)?SEARCH_NOTE_TYPE_ALL.replace("?val",val):SEARCH_NOTE_TYPE.replace("?by",by).replace("?val",val);
            ResultSet rs= st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                res.add(new NoteType(id, name, description));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<NoteType> searchWithPaging(String by, String val, Paging paging) {
        int offset= (paging.getCurrentPage()-1) * paging.getPageSizeItems();
        List<NoteType> res= new ArrayList<>();
        try {
            Statement st= Configuration.getConnection().createStatement();
            String query = "all".equals(by)?SEARCH_NOTE_TYPE_PAGING_ALL.replace("?val",val):SEARCH_NOTE_TYPE_PAGING.replace("?by",by).replace("?val",val);
            query= query.replace("?fie",paging.getSortField()).replace("?dir",paging.getSortDir());
            query= query.replace("?lim",Integer.toString(paging.getPageSizeItems())).replace("?off",Integer.toString(offset));
            ResultSet rs= st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                res.add(new NoteType(id, name, description));
            }

            int totalItems= search(by,val).size();
            int totalPages = (int) Math.ceil((double) totalItems / paging.getPageSizeItems());
            paging.setTotalItems(totalItems);
            paging.setTotalPages(totalPages);
            paging.setTotalItemsPage(res.size());
            paging.setSearchBy(by);
            paging.setSearchVal(val);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<NoteType> getAllWithPaging(Paging paging) {
        int offset= (paging.getCurrentPage()-1) * paging.getPageSizeItems();
        List<NoteType> res= new ArrayList<>();
        try {
            PreparedStatement pst = Configuration.getConnection().prepareStatement(SELECT_ALL_NOTE_TYPE_PAGING);
            pst.setString(1,paging.getSortField());
            pst.setString(2,paging.getSortDir());
            pst.setInt(3,paging.getPageSizeItems());
            pst.setInt(4,offset);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                res.add(new NoteType(id, name, description));
            }

            int totalItems= getAll().size();
            int totalPages = (int) Math.ceil((double) totalItems / paging.getPageSizeItems());
            paging.setTotalItems(totalItems);
            paging.setTotalPages(totalPages);
            paging.setTotalItemsPage(res.size());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }
}