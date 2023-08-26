import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Fresher extends Employee{
    private String graduationDate;
    private String graduationRank;
    private String education;

    // Constructor
    public Fresher(){

    }
    public Fresher(String fullName, Date birthDay, String phone, String email, int i, String graduationDate, String graduationRank, String education) {
        super();
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    // Getter and Setter
    public String getGraduationDate() {
        return graduationDate;
    }
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }
    public String getGraduationRank() {
        return graduationRank;
    }
    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    // Method
    @Override
    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        super.inputData(scanner, employeeList);
        System.out.print("Ngày tốt nghiệp: ");
        graduationDate = scanner.nextLine();

        System.out.print("Xếp hạng tốt nghiệp: ");
        graduationRank = scanner.nextLine();

        System.out.print("Trình độ học vấn: ");
        education = scanner.nextLine();
    }

    @Override
    public void showInfo(){
        System.out.println("Mã nhân viên: " + getId());
        System.out.println("Tên nhân viên: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Fresher");
        System.out.println("Ngày tốt nghiệp : " + graduationDate);
        System.out.println("Xếp hạng tốt nghiệp : " + graduationRank);
        System.out.println("Trình độ học vấn : " + education);
        System.out.println("Chứng chỉ :");

//        for (Certificate certificate : certificatesList) {
//            certificate.displayInfo();
//        }
    }
}
