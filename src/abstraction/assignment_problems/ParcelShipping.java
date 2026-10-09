package abstraction.assignment_problems;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;
    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    public abstract double calculateCharge();
}

class Standard extends Parcel {
    public Standard(double weight, double declaredValue) { super(weight, declaredValue); }
    public double calculateCharge() { return 40 + (10 * weight); }
}

class Express extends Parcel implements Insurable {
    public Express(double weight, double declaredValue) { super(weight, declaredValue); }
    public double calculateCharge() { return 80 + (15 * weight); }
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; }
}

class Fragile extends Parcel implements Insurable {
    public Fragile(double weight, double declaredValue) { super(weight, declaredValue); }
    public double calculateCharge() { return 40 + (10 * weight) + 50; }
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; }
}

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p = null;
            
            if (type.equals("STANDARD")) p = new Standard(weight, value);
            else if (type.equals("EXPRESS")) p = new Express(weight, value);
            else if (type.equals("FRAGILE")) p = new Fragile(weight, value);
            
            if (p != null) {
                double charge = p.calculateCharge();
                double insurance = 0;
                if (p instanceof Insurable) {
                    insurance = ((Insurable) p).calculateInsurance(value);
                }
                double total = charge + insurance;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", type, charge, insurance, total);
                grandTotal += total;
            }
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}