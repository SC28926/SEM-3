package week6hw;

class Employe {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employe(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5 {
    public static void main(String[] args) {
        Employe emp1 = new Employe("Amit", 50000);
        Employe emp2 = new Employe("Bhavna", 60000);
        Employe emp3 = new Employe("Chetan", 55000);

        Employe.printCompanyInfo();
    }
}