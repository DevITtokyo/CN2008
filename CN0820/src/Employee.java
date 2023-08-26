import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Employee {
    protected String id, fullName, email, phone, employeeType;
    protected Date birthDay;
    protected int employeeCount;
    protected String certificate;

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    // Constructor
    public Employee() {
    }
    public Employee(String id, String fullName, String email, String phone, String employeeType, Date birthDay, int employeeCount, String certificate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.employeeType = employeeType;
        this.birthDay = birthDay;
        this.employeeCount = employeeCount;
        this.certificate = certificate;
    }

    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        System.out.print("Nhập vào ID : ");
        do {
            this.id = scanner.nextLine();
            if (employeeList.size() > 0) {
                boolean isExistId = false;
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getId().equals(this.id)) {
                        isExistId = true;
                        break;
                    }
                }
                if (isExistId) {
                    System.err.println("Mã id đã tồn tại, vui lòng nhập lại");
                }else {
                    break;
                }
            } else {
                break;
            }
        } while (true);
        System.out.print("Nhập vào tên nhân viên :");
        do {
            this.fullName = scanner.nextLine();
            if (this.fullName.length() > 5 && this.fullName.length() < 50) {
                break;
            } else {
                System.err.println("Tên nhân viên phải trong khoảng 6 - 50 ký tự, vui lòng nhập lại");
            }

        } while (true);
        System.out.print("Nhập vào email : ");
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        do {
            this.email = scanner.nextLine();
            if (Pattern.matches(emailRegex, this.email)) {
                break;
            } else {
                System.err.println("Email không đúng định dạng, vui lòng nhập lại");
            }
        } while (true);
//        System.out.println("Nhập vào năng lực nhân viên : ");
//        System.out.println("0. Experience");
//        System.out.println("1. Fresher");
//        System.out.println("2. Intern");
//        do {
//            int n = Integer.parseInt(scanner.nextLine());
//            if (n == 0) {
//                this.employeeType = "EXPERIENCE";
//                break;
//            } else if (n == 1) {
//                this.employeeType = "FRESHER";
//                break;
//            } else {
//                this.employeeType = "INTERN";
//                break;
//            }
//        } while (true);
        System.out.print("Nhập vào số điện thoại : ");
        String phonRegex = "[0-9]{10}";
        do {
            this.phone = scanner.nextLine();
            if (Pattern.matches(phonRegex, this.phone)) {
                break;
            } else {
                System.err.println("Số điện thoại không đúng định dạng, vui lòng nhập lại");
            }
        } while (true);
        this.birthDay = validateBirthday(scanner);

    }
    public static Date validateBirthday (Scanner scanner) throws ParseException {
        System.out.print("Nhập vào ngày sinh của nhân viên theo định dạng dd/MM/yyyy: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
                Date birthday = sdf.parse(scanner.nextLine());
                Calendar cal = Calendar.getInstance();
                cal.setTime(birthday);
                if (cal.get(Calendar.YEAR) < 2005) {
                    return birthday;
                } else {
                    System.err.println("Năm sinh phải trước năm 2005, vui lòng nhập lại");
                }
        } while (true);
    }

    abstract void showInfo();
    @Override
    public String toString() {
        return"Employee{" + "id='" + id + '\'' + "- Tên nhân viên : '" + fullName + '\'' + "- Email :'" + email + '\'' + "- Số điện thoại : '" + phone + '\'' + "- EmployeeType : '" + employeeType + '\'' + "- BirthDay : " + birthDay + "- EmployeeCount : " + employeeCount + "- Certificate : '" + certificate + '\'' + '}';
    }
}
