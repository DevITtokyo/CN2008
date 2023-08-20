import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.*;

public class EmployeeManagement {
    public static List<Employee> employeeList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********************** Employee Management System ***********************");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Find All Interns");
            System.out.println("5. Find All Experienced Employees");
            System.out.println("6. Find All Freshers");
            System.out.println("7. Sort Employees by BirthDay");
            System.out.println("8. Sort Employees by FullName");
            System.out.println("9. Display Employee");
            System.out.println("10. Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
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
                    break;
                case 8:
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
    private static void addEmployee() {
        System.out.println("Select employee type:");
        System.out.println("0. Experience");
        System.out.println("1. Fresher");
        System.out.println("2. Intern");
        System.out.print("Enter employee type: ");
        int employeeType = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Enter birth day: ");
        String birthDay = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        Employee newEmployee = null;

        if (employeeType == 0) {
            System.out.println("Enter years of experience: ");
            int expInYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter professional skill: ");
            String proSkill = scanner.nextLine();

            newEmployee = new Experience(fullName, birthDay, phone, email, expInYear, proSkill);
        } else if (employeeType == 1) {
            System.out.println("Enter graduation date: ");
            String graduationDate = scanner.nextLine();

            System.out.println("Enter graduation rank: ");
            String graduationRank = scanner.nextLine();

            System.out.println("Enter education: ");
            String education = scanner.nextLine();

            newEmployee = new Fresher(fullName, birthDay, phone, email, graduationDate, graduationRank, education);
        } else if (employeeType == 2) {
            System.out.println("Enter major: ");
            String majors = scanner.nextLine();

            System.out.println("Enter semester: ");
            String semester = scanner.nextLine();

            System.out.println("Enter university name: ");
            String universityName = scanner.nextLine();

            newEmployee = new Intern(fullName, birthDay, phone, email, majors, semester, universityName);
        }

        if (newEmployee != null) {
            employeeList.add(newEmployee);
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Invalid employee type.");
        }
    }
    // 2. Update Employee
    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employeeToUpdate = findEmployeeById(employeeId);
        if (employeeToUpdate == null) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }

        // Hiển thị thông tin hiện tại của nhân viên
        System.out.println("Current info:");
        employeeToUpdate.showInfo();

        // Update thông tin của nhân viên
        employeeToUpdate.inputData();
        System.out.println("Employee info updated successfully.");
    }
    // 3. Delete Employee
    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int employeeId = Integer.parseInt(scanner.nextLine());

        Employee employeeToDelete = findEmployeeById(employeeId);
        if (employeeToDelete == null) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }
        employeeList.remove(employeeToDelete);
        System.out.println("Employee deleted successfully.");
    }
    // Phương thức tìm nhân viên bằng Id
    private static Employee findEmployeeById(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getID() == employeeId) {
                return employee;
            }
        }
        return null;
    }
    // 4. Find All Interns
    private static void findAllInterns() {
        System.out.println("List of all interns:");
        for (Employee employee : employeeList) {
            if (employee instanceof Intern) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 5. Find All Experienced Employees
    private static void findAllExperiencedEmployees() {
        System.out.println("List of all experienced employees:");
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
    private static void sortEmployeesByBirthDay(boolean ascending) {
        // tạo một bộ so sánh Comparator để sắp xếp danh sách nhân viên dựa vào ngày sinh BirthDay
        Comparator<Employee> birthDayComparator = Comparator.comparing(Employee::getBirthDay);
        // Biến ascending để sắp xếp có theo thứ tự tăng dần hay giảm dần.
        if (!ascending) {
            // ascending: true, birthDayComparator vẫn giữ nguyên sắp xếp tăng dần
            // ascending: false, bộ so sánh sẽ bị đảo ngược, sắp xếp ngược lại
            birthDayComparator = birthDayComparator.reversed();
        }

        Collections.sort(employeeList, birthDayComparator);
        // Hiển thị
        System.out.println("List of employees sorted by BirthDay:");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }
    // 8. Sort Employees by FullName
    private static void sortEmployeesByFullName(boolean ascending) {
        // tạo một bộ so sánh Comparator để sắp xếp danh sách nhân viên dựa vào tên FullName
        Comparator<Employee> fullNameComparator = Comparator.comparing(Employee::getFullName);
        if (!ascending) {
            // ascending: true, fullNameComparator vẫn giữ nguyên sắp xếp tăng dần
            // ascending: false, bộ so sánh sẽ bị đảo ngược, sắp xếp ngược lại
            fullNameComparator = fullNameComparator.reversed();
        }

        Collections.sort(employeeList, fullNameComparator);
        // Hiển thị
        System.out.println("List of employees sorted by FullName:");
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
