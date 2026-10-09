package abstraction.assignment_problems;

import java.util.Scanner;

interface SaverMode {
    boolean supportsSaverMode();
}

abstract class Appliance {
    protected double hours;
    public Appliance(double hours) {
        this.hours = hours;
    }
    protected abstract double getPower();
    public double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours); }
    protected double getPower() { return 150.0; }
}

class Ac extends Appliance implements SaverMode {
    public Ac(double hours) { super(hours); }
    protected double getPower() { return 1500.0; }
    public boolean supportsSaverMode() { return true; }
}

class Tv extends Appliance {
    public Tv(double hours) { super(hours); }
    protected double getPower() { return 100.0; }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours) { super(hours); }
    protected double getPower() { return 500.0; }
    public boolean supportsSaverMode() { return true; }
}

public class EnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
        double totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean isSaver = input.length == 3 && input[2].equals("SAVER");
            
            Appliance app = null;
            if (type.equals("FRIDGE")) app = new Fridge(hours);
            else if (type.equals("AC")) app = new Ac(hours);
            else if (type.equals("TV")) app = new Tv(hours);
            else if (type.equals("WASHER")) app = new Washer(hours);
            
            if (app != null) {
                if (isSaver) {
                    if (app instanceof SaverMode && ((SaverMode) app).supportsSaverMode()) {
                        double units = app.calculateUnits() * 0.75;
                        double cost = units * 8.0;
                        System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
                        totalCost += cost;
                    } else {
                        System.out.printf("%s: saver mode not supported\n", type);
                    }
                } else {
                    double units = app.calculateUnits();
                    double cost = units * 8.0;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
                    totalCost += cost;
                }
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}