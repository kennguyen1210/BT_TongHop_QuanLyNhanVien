package business.model;

import business.util.InputMethods;

import java.io.Serializable;

public class Department implements Serializable {
    private String departmentId;
    private String departmentName;
    private String description;

    public Department() {
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void inputData(){
        System.out.println("Nhap ten phong ban: ");
        this.departmentName = InputMethods.getString();
        System.out.println("Nhap mo ta :");
        this.description = InputMethods.getString();
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
