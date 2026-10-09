package abstraction.assignment_problems;

import java.util.Scanner;

interface NightService {
    boolean canOfferNightService();
}

abstract class Cab {
    protected double km;
    public Cab(double km) {
        this.km = km;
    }
    protected abstract double getRate();
    public double calculateBaseFare() {
        double fare = km * getRate();
        return Math.max(fare, 100.0);
    }
}

class Mini extends Cab {
    public Mini(double km) { super(km); }
    protected double getRate() { return 10.0; }
}

class Sedan extends Cab implements NightService {
    public Sedan(double km) { super(km); }
    protected double getRate() { return 14.0; }
    public boolean canOfferNightService() { return true; }
}

class Suv extends Cab implements NightService {
    public Suv(double km) { super(km); }
    protected double getRate() { return 18.0; }
    public boolean canOfferNightService() { return true; }
}

public class Fare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            
            Cab cab = null;
            if (cabType.equals("MINI")) cab = new Mini(km);
            else if (cabType.equals("SEDAN")) cab = new Sedan(km);
            else if (cabType.equals("SUV")) cab = new Suv(km);
            
            if (cab != null) {
                if (time.equals("NIGHT")) {
                    if (cab instanceof NightService && ((NightService) cab).canOfferNightService()) {
                        double fare = cab.calculateBaseFare() * 1.20;
                        System.out.printf("%s: %.2f\n", cabType, fare);
                        total += fare;
                    } else {
                        System.out.printf("%s: night service not available\n", cabType);
                    }
                } else {
                    double fare = cab.calculateBaseFare();
                    System.out.printf("%s: %.2f\n", cabType, fare);
                    total += fare;
                }
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}