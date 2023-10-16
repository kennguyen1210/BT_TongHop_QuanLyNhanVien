package business.model;

import business.util.FomartData;
import business.util.FormatTime;
import business.util.InputMethods;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Employee implements Serializable {
    private Long employeeId;
    private String employeeName;
    private LocalDate birthday;
    private String position;
    private String departmentId;

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public void inputData(){
        System.out.println("Nhap ten nhan vien : ");
        this.employeeName = InputMethods.getString();
        while (true) {
            System.out.println("Nhap ngay sinh ( theo dinh dang dd/MM/yyyy): ");
            String date = InputMethods.getString();
            try {
                this.birthday = FomartData.formatDate(date);
                break;
            } catch (NullPointerException | DateTimeParseException e) {
                System.err.println("Ngay sinh chua hop le " + e.getMessage());
            }
        }
        System.out.println("Nhap vi tri cong tac :");
        this.position = InputMethods.getString();
        System.out.println("Nhap Id phong ban : ");
        this.departmentId = InputMethods.getString();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + FormatTime.formatTime(birthday) +
                ", position='" + position + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
