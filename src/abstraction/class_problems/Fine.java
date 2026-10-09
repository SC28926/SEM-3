package abstraction.class_problems;

import java.util.Scanner;

abstract class Staf {
    String name;
    Staf(String name) {
        this.name = name;
    }
    abstract double getPay();
}

class FullTi extends Staff {
    double salary;
    FullTi(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    double getPay() {
        return salary;
    }
}

class Hour extends Staff {
    double hours, rate;
    Hour(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    double getPay() {
        return hours <= 40 ? hours * rate : (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Inter extends Staff {
    double stipend;
    Inter(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    double getPay() {
        return stipend;
    }
}

public class Fine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s = null;
            if (type.equals("FULLTIME")) {
                s = new FullTime(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                s = new Hourly(name, sc.nextDouble(), sc.nextDouble());
            } else if (type.equals("INTERN")) {
                s = new Intern(name, sc.nextDouble());
            }
            if (s != null) {
                double pay = s.getPay();
                total += pay;
                System.out.printf("%s: %.2f\n", name, pay);
            }
        }
        System.out.printf("Total Payroll: %.2f\n", total);
        sc.close();
    }
}