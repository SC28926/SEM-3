package inheritence.class_problems;

import java.util.Scanner;

class Staff {
    protected String name;
    protected double baseSalary;

    public Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return 0.0;
    }

    public double getTotalSalary() {
        return baseSalary + getBonus();
    }

    public String getRole() {
        return "Staff";
    }

    public void printDetails() {
        System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                name, getRole(), baseSalary, getBonus(), getTotalSalary());
    }
}

class Teacher extends Staff {
    public Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 5000.0;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    public LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getRole() {
        return "LabAssistant";
    }
}

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double baseSalary = scanner.nextDouble();

            switch (type) {
                case "Teacher":
                    staffList[i] = new Teacher(name, baseSalary);
                    break;
                case "LabAssistant":
                    staffList[i] = new LabAssistant(name, baseSalary);
                    break;
                default:
                    staffList[i] = new Staff(name, baseSalary);
                    break;
            }
        }

        double grandTotal = 0.0;

        for (Staff s : staffList) {
            s.printDetails();
            grandTotal += s.getTotalSalary();
        }

        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
        scanner.close();
    }
}