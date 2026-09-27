package week8hw;

import java.util.Scanner;

interface BonusCalculable {
    double calculateBonus(double salary);
}

abstract class Employee implements BonusCalculable {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus(double salary) {
        return 2000.00;
    }
}

class EmployeeFactory {
    public static Employee createEmployee(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new InternEmployee(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            employees[i] = EmployeeFactory.createEmployee(type, name, salary);
        }

        for (int i = 0; i < n; i++) {
            double bonus = employees[i].calculateBonus(employees[i].salary);
            totalBonus += bonus;
            System.out.printf("%s: %.2f\n", employees[i].getName(), bonus);
        }
        
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        scanner.close();
    }
}