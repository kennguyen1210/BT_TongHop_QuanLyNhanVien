package business.serviceImplement;

import business.model.Employee;

import java.util.List;

public interface IEmployeeService extends IGeneret<Employee, Long>{
    Long getNewId();
    boolean deleteByDepartmentId(String id);
    List<Employee> displayAll();
    List<Employee> findByName(String name);
}
