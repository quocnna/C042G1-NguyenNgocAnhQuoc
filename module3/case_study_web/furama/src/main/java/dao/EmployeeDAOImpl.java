package dao;

import common.Paging;
import model.Employee;
import model.EmployeeDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String SELECT_EMPLOYEEDTO = "select e.id, e.name, e.birthday, e.cardid, e.phone, e.email, e.address, e.salary, p.id, p.name, ed.id, ed.name, d.id, d.name, u.id, u.username from employee e \n" +
            "join division d on e.division_id= d.id\n" +
            "join position p on e.position_id= p.id\n" +
            "join education_degree ed on e.education_degree_id= ed.id\n" +
            "join user u on e.user_id= u.id;";

    private final String SELECT_EMPLOYEEDTO_PAGING= "select e.id, e.name, e.birthday, e.cardid, e.phone, e.email, e.address, e.salary, p.id, p.name, ed.id, ed.name, d.id, d.name, u.id, u.username from employee e \n" +
            "join division d on e.division_id= d.id\n" +
            "join position p on e.position_id= p.id\n" +
            "join education_degree ed on e.education_degree_id= ed.id\n" +
            "join user u on e.user_id= u.id order by e.?fie ?dir limit ?lim offset ?off";
    @Override
    public Optional<Employee> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public List<Employee> getAllWithPaging(Paging paging) {
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(String ids) {
        return false;
    }

    @Override
    public boolean deleteCascade(String ids) {
        return false;
    }

    @Override
    public List<Employee> search(String by, String val) {
        return null;
    }

    @Override
    public List<Employee> searchWithPaging(String by, String val, Paging paging) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllDTO() {
        List<EmployeeDTO> res = new ArrayList<>();
        try {
            PreparedStatement pst = ConfigurationDB.getConnection().prepareStatement(SELECT_EMPLOYEEDTO);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String birthday = rs.getString(3);
                String cardid = rs.getString(4);
                String phone = rs.getString(5);
                String email = rs.getString(6);
                String address = rs.getString(7);
                double salary = rs.getDouble(8);
                int position_id = rs.getInt(9);
                String position_name = rs.getString(10);
                int education_degree_id = rs.getInt(11);
                String education_degree_name = rs.getString(12);
                int division_id = rs.getInt(13);
                String division_name = rs.getString(14);
                int user_id = rs.getInt(15);
                String username = rs.getString(16);
                res.add(new EmployeeDTO(id, name, birthday, cardid,phone,email,address,salary,position_id,position_name,
                        education_degree_id,education_degree_name,division_id,division_name,user_id,username));
            }
        } catch (SQLException e) {

        }
        return res;
    }

    @Override
    public List<EmployeeDTO> getAllDTOWithPaging(Paging paging) {
        int offset = (paging.getCurrentPage() - 1) * paging.getPageSizeItems();
        List<EmployeeDTO> res = new ArrayList<>();
        try {
            Statement st = ConfigurationDB.getConnection().createStatement();
            String query = SELECT_EMPLOYEEDTO_PAGING.replace("?fie", paging.getSortField()).replace("?dir", paging.getSortDir());
            query = query.replace("?lim", Integer.toString(paging.getPageSizeItems())).replace("?off", Integer.toString(offset));
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String birthday = rs.getString(3);
                String cardid = rs.getString(4);
                String phone = rs.getString(5);
                String email = rs.getString(6);
                String address = rs.getString(7);
                double salary = rs.getDouble(8);
                int position_id = rs.getInt(9);
                String position_name = rs.getString(10);
                int education_degree_id = rs.getInt(11);
                String education_degree_name = rs.getString(12);
                int division_id = rs.getInt(13);
                String division_name = rs.getString(14);
                int user_id = rs.getInt(15);
                String username = rs.getString(16);
                res.add(new EmployeeDTO(id, name, birthday, cardid,phone,email,address,salary,position_id,position_name,
                        education_degree_id,education_degree_name,division_id,division_name,user_id,username));
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
    public List<EmployeeDTO> searchDTO(String by, String val) {
        return null;
    }

    @Override
    public List<EmployeeDTO> searchDTOWithPaging(String by, String val, Paging paging) {
        return null;
    }
}
