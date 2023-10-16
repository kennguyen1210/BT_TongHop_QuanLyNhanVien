package business.serviceImplement;

import business.model.Department;

import java.util.List;

public interface IDepartService extends IGeneret<Department, String>{
    List<Department> displayAll();
}
