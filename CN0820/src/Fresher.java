import sun.nio.ch.sctp.SctpNet;

import java.util.Scanner;

public class Fresher extends Employee{
    private String graduationDate;
    private String graduationRank;
    private String education;

    // Constructor
    public Fresher(String fullName, String birthDay, String phone, String email,
                   String graduationDate, String graduationRank, String education) {
        super(fullName, birthDay, phone, email, 1);
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

//    public void inputData() {
//        super.inputData();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter graduation date: ");
//        graduationDate = scanner.nextLine();
//
//        System.out.print("Enter graduation rank: ");
//        graduationRank = scanner.nextLine();
//
//        System.out.print("Enter education: ");
//        education = scanner.nextLine();
//    }

    @Override
    public void showInfo(){
        System.out.println("Employee ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Fresher");
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("Education: " + education);
        System.out.println("Certificates:");

//        for (Certificate certificate : certificatesList) {
//            certificate.displayInfo();
//        }
    }
}
