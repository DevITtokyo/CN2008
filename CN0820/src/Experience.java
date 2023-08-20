import java.util.Scanner;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    // Constructor
    public Experience(String fullName, String birthDay, String phone, String email, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    // Getter and Setter
    public int getExpInYear() {
        return expInYear;
    }
    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
    public String getProSkill() {
        return proSkill;
    }
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    @Override
//    public void inputData() {
//        super.inputData();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter years of experience: ");
//        expInYear = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        System.out.print("Enter professional skill: ");
//        proSkill = scanner.nextLine();
//    }
    public void showInfo() {
        System.out.println("Employee ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Experience");
        System.out.println("Experience in Years: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
        System.out.println("Certificates:");
        // Display certificates information
//        for (Certificate certificate : certificatesList) {
//            certificate.displayInfo();
//        }
    }
}
