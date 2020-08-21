package bussiness;

import common.Paging;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;
import model.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public class EmployeeManagerImpl implements EmployeeManager {
    EmployeeDAO employeeDAO= new EmployeeDAOImpl();
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
        return employeeDAO.getAllDTO();
    }

    @Override
    public List<EmployeeDTO> getAllDTOWithPaging(Paging paging) {
        return employeeDAO.getAllDTOWithPaging(paging);
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
