package run;

import business.model.Department;
import business.model.Employee;
import business.serviceImplement.IDepartService;
import business.serviceImplement.IEmployeeService;
import business.serviceImplement.implement.departmentService;
import business.serviceImplement.implement.employeeService;
import business.util.InputMethods;

import java.util.List;

public class EmployeeManagement {
    public static IDepartService departService = new departmentService();
    public static IEmployeeService employeeService = new employeeService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("============== ***** MENU ***** ===============");
            System.out.println("1.Quan ly phong ban");
            System.out.println("2.Quan ly nhan vien");
            System.out.println("3.Thoat");
            System.out.println("Nhap lua chon : ");
            int choise = InputMethods.getInteger();
            switch (choise) {
                case 1:
                    DepartmentManager();
                    break;
                case 2:
                    EmployeeManager();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lua chon chua hop ly! Hya nhap lai!");
            }
        }
    }

    public static void DepartmentManager() {
        while (true) {
            System.out.println("========== **** MENU QUAN LY PHONG BAN **** =============");
            System.out.println("1.Hien thi danh sach tat ca phong ban");
            System.out.println("2.Them moi phong ban");
            System.out.println("3.Chinh sua thong tin");
            System.out.println("4.Xoa phong ban");
            System.out.println("5.Quay lai Menu chinh");
            int t = InputMethods.getInteger();
            switch (t) {
                case 1:
                    List<Department> list = departService.displayAll();
                    if(list.isEmpty()){
                        System.out.println("Chua co phong ban nao trong danh sach!");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.println("Nhap so luong them moi");
                    int soLuong = InputMethods.getInteger();
                    for (int i = 0; i < soLuong; i++) {
                        System.out.println("Nhap lan :" + (i + 1));
                        Department department = new Department();
                        System.out.println("Nhap ID phong ban: ");
                        department.setDepartmentId(InputMethods.getString());
                        department.inputData();
                        departService.save(department);
                    }
                    break;
                case 3:
                    System.out.println("Nhap Id phong ban muon chinh sua :");
                    String id = InputMethods.getString();
                    Department update = departService.findById(id);
                    if (update != null) {
                        System.out.println(update);
                        update.inputData();
                        departService.save(update);
                    }
                    break;
                case 4:
                    System.out.println("Nhap id phong ban muon xoa");
                    String deleteId = InputMethods.getString();
                    Department deleteDP = departService.findById(deleteId);
                    if (deleteDP != null) {
                        departService.delete(deleteId);
                        employeeService.deleteByDepartmentId(deleteDP.getDepartmentId());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Lua chon chua hop ly! Hay nhap lai!");
            }
        }
    }

    public static void EmployeeManager() {
        while (true) {
            System.out.println("========== **** MENU QUAN LY NHAN VIEN **** =============");
            System.out.println("1.Hien thi danh sach tat ca nhan vien");
            System.out.println("2.Them moi nhan vien");
            System.out.println("3.Chinh sua thong tin");
            System.out.println("4.Xoa nhan vien theo id");
            System.out.println("5.tim kiem theo ten nhan vien");
            System.out.println("6.Quay lai Menu chinh");
            int t = InputMethods.getInteger();
            switch (t) {
                case 1:
                    List<Employee> list = employeeService.displayAll();
                    if(list.isEmpty()){
                        System.out.println("Chua co nhan vien nao trong danh sach!");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;
                case 2:
                    List<Department> list1 = departService.displayAll();
                    if(list1.isEmpty()){
                        System.out.println("Chua co phong ban nao trong danh sach!" +
                                "\n hay them moi phong ban truoc khi them nhan vien");
                    } else {
                        System.out.println("Nhap so luong them moi");
                        int soLuong = InputMethods.getInteger();
                        for (int i = 0; i < soLuong; i++) {
                            System.out.println("Nhap lan :" + (i + 1));
                            Employee employee = new Employee();
                            employee.setEmployeeId(employeeService.getNewId());
                            employee.inputData();
                            employeeService.save(employee);
                        }
                    }

                    break;
                case 3:
                    System.out.println("Nhap Id nhan vien muon chinh sua :");
                    Long id = InputMethods.getLong();
                    Employee update = employeeService.findById(id);
                    if (update != null) {
                        System.out.println(update);
                        update.inputData();
                        employeeService.save(update);
                    }
                    break;
                case 4:
                    System.out.println("Nhap id nhan vien muon xoa");
                    Long deleteId = InputMethods.getLong();
                    Employee deleteDP = employeeService.findById(deleteId);
                    if (deleteDP != null) {
                        employeeService.delete(deleteId);
                    }
                    break;
                case 5:
                    System.out.println("Nhap ten nhan vien muon tim : ");
                    String name = InputMethods.getString();
                    employeeService.findByName(name).forEach(System.out::println);
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Lua chon chua hop ly! Hay nhap lai!");
            }
        }
    }
}
