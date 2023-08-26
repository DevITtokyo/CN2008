import java.text.ParseException;
import java.util.*;

public class EmployeeManagement {
    public static List<Employee> employeeList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********************** Employee Management System ***********************");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Cập nhât nhân viên");
            System.out.println("3. Xoá Employee");
            System.out.println("4. Tìm tất cả Interns");
            System.out.println("5. Tìm tất cả Experienced Employees");
            System.out.println("6. Tìm tất cả Freshers");
            System.out.println("7. Sắp xếp nhân viên theo ngày sinh");
            System.out.println("8. Sắp xếp nhân viên theo tên");
            System.out.println("9. Hiển thị nhân viên");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn là : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee(scanner);
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    findAllInterns();
                    break;
                case 5:
                    findAllExperiencedEmployees();
                    break;
                case 6:
                    findAllFreshers();
                    break;
                case 7:
                    sortBirthday();
                    break;
                case 8:
                    sortName();
                    break;
                case 9:
                    displayEmployees();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Please enter 1-9");
            }
        } while (true);
    }
    // 1. Add Employee
    private static void addEmployee() throws ParseException {
        System.out.println("Hãy chọn kiểu nhân viên:");
        System.out.println("0. Experience");
        System.out.println("1. Fresher");
        System.out.println("2. Intern");
        System.out.print("Lựa chọn của bạn là: ");
        int employeeType = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào số lượng nhân viên bạn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (employeeType == 0) {
                Experience experience = new Experience();
                experience.inputData(scanner, employeeList);
                employeeList.add(experience);
            } else if (employeeType == 1) {
                Fresher fresher = new Fresher();
                fresher.inputData(scanner, employeeList);
                employeeList.add(fresher);
            } else {
                Intern intern = new Intern();
                intern.inputData(scanner, employeeList);
                employeeList.add(intern);
            }
        }
    }
//     2. Update Employee
    public static void updateEmployee(Scanner scanner) throws ParseException {
        System.out.print("Nhập mã nhân viên muốn sửa : ");
        String updateId = scanner.nextLine();
        boolean isExitsId = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(updateId)) {
                isExitsId = true;
                System.out.println("Hãy chọn kiểu nhân viên:");
                System.out.println("0. Experience");
                System.out.println("1. Fresher");
                System.out.println("2. Intern");
                System.out.print("Lựa chọn của bạn là: ");
                int employeeType = Integer.parseInt(scanner.nextLine());
                if (employeeType == 0) {
                    Experience experience = new Experience();
                    experience.inputData(scanner, employeeList);
                    employeeList.set(i, experience);
                } else if (employeeType == 1) {
                    Fresher fresher = new Fresher();
                    fresher.inputData(scanner, employeeList);
                    employeeList.set(i, fresher);
                } else {
                    Intern intern = new Intern();
                    intern.inputData(scanner, employeeList);
                    employeeList.set(i, intern);
                }
                break;
            }
        }
        if (!isExitsId) {
            System.err.println("Mã nhân viên nhập không tồn tại ");
        }
    }
    // 3. Delete Employee
    private static void deleteEmployee() {
        System.out.print("Nhập id bạn muốn xoá: ");
        String editId = scanner.nextLine();
        boolean isExits = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(editId)) {
                isExits = true;
                employeeList.remove(i);
                break;
            }
        }
        if (!isExits) {
            System.err.println("Mã id không tồn tại");
        }else {
            System.out.println("Đã xóa thành công!");
        }
    }
    // Phương thức tìm nhân viên bằng Id
    private static Employee findEmployeeById(String employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
    // 4. Find All Interns
    private static void findAllInterns() {
        System.out.println("Danh sách interns:");
        for (Employee employee : employeeList) {
            if (employee instanceof Intern) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 5. Find All Experienced Employees
    private static void findAllExperiencedEmployees() {
        System.out.println("Danh sách experienced employees:");
        for (Employee employee : employeeList) {
            if (employee instanceof Experience) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 6. Find All Freshers
    private static void findAllFreshers() {
        System.out.println("List of all freshers:");
        for (Employee employee : employeeList) {
            if (employee instanceof Fresher) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 7. Sort Employees by BirthDay
    private static void sortBirthday(){
        Collections.sort(employeeList, Comparator.comparing(Employee::getBirthDay));
        System.out.println("Danh sách nhân viên sắp xếp theo ngày sinh:");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }
    // 8. Sort Employees by FullName
    private static void sortName(){
        Collections.sort(employeeList, Comparator.comparing(Employee::getFullName));
        System.out.println("Danh sách nhân viên sắp xếp theo tên:");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }

    // 9. Display Employyee
    private static void displayEmployees() {
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }

}
