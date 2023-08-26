import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;

    // Constructor
    public Intern(){

    }
    public Intern(String fullName, Date birthDay, String phone, String email, int i, String majors, String semester, String universityName) {
        super();
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    // Getter and Setter
    public String getMajors() {
        return majors;
    }
    public void setMajors(String majors) {
        this.majors = majors;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    // Method
    @Override
    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        super.inputData(scanner, employeeList);
        System.out.print("Chuyên ngành : ");
        majors = scanner.nextLine();

        System.out.print("Học kỳ: ");
        semester = scanner.nextLine();

        System.out.print("Nhập tên trường đại học: ");
        universityName = scanner.nextLine();

    }

    public void showInfo(){
        System.out.println("Mã nhân viên : " + getId());
        System.out.println("Tên nhân viên : " + getFullName());
        System.out.println("Birth Day : " + getBirthDay());
        System.out.println("Phone : " + getPhone());
        System.out.println("Email : " + getEmail());
        System.out.println("Employee Type : Intern");
        System.out.println("Chuyên ngành : " + majors);
        System.out.println("Học kỳ : " + semester);
        System.out.println("Tên trường : " + universityName);
    }
}
