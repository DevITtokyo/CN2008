import java.util.Scanner;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;

    // Constructor
    public Intern(String fullName, String birthDay, String phone, String email,
                  String majors, String semester, String universityName) {
        super(fullName, birthDay, phone, email, 2);
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
//    public void inputData() {
//        super.inputData();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter major: ");
//        majors = scanner.nextLine();
//
//        System.out.print("Enter semester: ");
//        semester = scanner.nextLine();
//
//        System.out.print("Enter university name: ");
//        universityName = scanner.nextLine();
//
//    }

    public void showInfo(){
        System.out.println("Employee ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Intern");
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}
