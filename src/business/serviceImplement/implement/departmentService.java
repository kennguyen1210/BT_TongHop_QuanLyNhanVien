package business.serviceImplement.implement;

import business.model.Department;
import business.serviceImplement.IDepartService;
import business.util.IOFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class departmentService implements IDepartService {
    private List<Department> departments;
    public departmentService(){
        departments = IOFile.readFileByBinary(IOFile.DEPARTMENT_PATH);
    }
    @Override
    public boolean save(Department department) {
        Department departmentOld = findById(department.getDepartmentId());
        if(findById(department.getDepartmentId())!=null){
            // chuc nang cap nhat
            departments.set(departments.indexOf(departmentOld),department);
        } else {
            // chu nang cap nhat
            departments.add(department);
        }
        IOFile.writeToFileBinary(IOFile.DEPARTMENT_PATH,departments);
        return true;
    }

    @Override
    public void delete(String id) {
        departments.remove(findById(id));
        IOFile.writeToFileBinary(IOFile.DEPARTMENT_PATH,departments);
    }

    @Override
    public List<Department> findAll() {
        return departments;
    }

    @Override
    public Department findById(String id) {
        return departments.stream()
                .filter(d->d.getDepartmentId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Department> displayAll() {
        return departments.stream().sorted(Comparator.comparing(Department::getDepartmentName)).collect(Collectors.toList());
    }
}
