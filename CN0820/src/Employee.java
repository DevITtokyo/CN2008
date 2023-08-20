import java.util.Scanner;

public abstract class Employee {
    private static int employeeCount = 0;

    private int ID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private int employeeType;
    // Contructor

    public Employee() {
    }
    public Employee(String fullName, String birthDay, String phone, String email, int employeeType) {
        this.ID = ++employeeCount;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
    }
    // Getter and Setter
    public static int getEmployeeCount() {
        return employeeCount;
    }
    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }
    public void showInfo() {

    }
    public void inputData(){
//        System.out.println("Enter employee type (0: Experience, 1: Fresher, 2: Intern): ");
        Scanner scanner = new Scanner(System.in);
        int employeeType = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Enter birth day: ");
        String birthDay = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

    }
}
