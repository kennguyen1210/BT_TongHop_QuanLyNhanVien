package business.serviceImplement.implement;

import business.model.Employee;
import business.serviceImplement.IEmployeeService;
import business.util.IOFile;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class employeeService implements IEmployeeService {
    private List<Employee> employees;
    public employeeService(){
        employees = IOFile.readFileByBinary(IOFile.EMPLOYEE_PATH);
    }
    @Override
    public Long getNewId() {
        return employees.stream().map(Employee::getEmployeeId).max(Long::compareTo).orElse(0L)+1;
    }

    @Override
    public boolean save(Employee employee) {
        Employee employeeOld = findById(employee.getEmployeeId());
        if(employeeOld!= null){
            employees.set(employees.indexOf(employeeOld),employee);
        } else {
            employees.add(employee);
        }
        IOFile.writeToFileBinary(IOFile.EMPLOYEE_PATH,employees);
        return true;
    }

    @Override
    public void delete(Long id) {
        employees.remove(findById(id));
        IOFile.writeToFileBinary(IOFile.EMPLOYEE_PATH,employees);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return employees.stream().filter(e->e.getEmployeeId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public boolean deleteByDepartmentId(String id){
       employees = employees.stream().filter(e->!e.getDepartmentId().equals(id)).collect(Collectors.toList());
       IOFile.writeToFileBinary(IOFile.EMPLOYEE_PATH,employees);
       return true;
    }
    @Override
    public List<Employee> displayAll(){
        return employees.stream().sorted(Comparator.comparing(Employee::getBirthday)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByName(String name) {
        return employees.stream().filter(e->e.getEmployeeName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }
}
