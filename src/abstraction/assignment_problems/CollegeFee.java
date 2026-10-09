package abstraction.assignment_problems;

import java.util.Scanner;

interface TransportUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    public Student(String name) {
        this.name = name;
    }
    public abstract double calculateTuition();
}

class DayScholar extends Student implements TransportUser {
    public DayScholar(String name) { super(name); }
    public double calculateTuition() { return 40000; }
    public double getTransportFee() { return 12000; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    public double calculateTuition() { return 40000 + 60000; }
}

class Scholar extends Student implements TransportUser {
    public Scholar(String name) { super(name); }
    public double calculateTuition() { return 20000; }
    public double getTransportFee() { return 12000; }
}

public class CollegeFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if(type.equals("DAY")) {
                sc.next();
                type = "DAY_SCHOLAR";
            }
            String name = sc.next();
            Student s = null;
            
            if (type.equals("DAY_SCHOLAR")) s = new DayScholar(name);
            else if (type.equals("HOSTELLER")) s = new Hosteller(name);
            else if (type.equals("SCHOLAR")) s = new Scholar(name);
            
            if (s != null) {
                double fee = s.calculateTuition();
                if (s instanceof TransportUser) {
                    fee += ((TransportUser) s).getTransportFee();
                }
                System.out.printf("%s: %.2f\n", name, fee);
                totalCollected += fee;
            }
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}