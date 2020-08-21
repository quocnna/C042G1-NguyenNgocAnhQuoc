package bussiness;

import common.Paging;
import dao.BaseDAO;
import model.Employee;
import model.EmployeeDTO;

import java.util.List;

public interface EmployeeManager extends BaseDAO<Employee> {
    List<EmployeeDTO> getAllDTO();
    List<EmployeeDTO> getAllDTOWithPaging(Paging paging);
    List<EmployeeDTO> searchDTO(String by, String val);
    List<EmployeeDTO> searchDTOWithPaging(String by, String val, Paging paging);
}
