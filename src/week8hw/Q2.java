package week8hw;

import java.util.Scanner;

enum VehicleType {
    BIKE {
        double calculateCharge(int hours) {
            return hours * 10.0;
        }
    },
    CAR {
        double calculateCharge(int hours) {
            return 30.0 + (hours > 1 ? (hours - 1) * 20.0 : 0.0);
        }
    },
    TRUCK {
        double calculateCharge(int hours) {
            return Math.max(100.0, hours * 50.0);
        }
    };

    abstract double calculateCharge(int hours);
}

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        
        String[] types = new String[n];
        double[] charges = new double[n];
        double totalCharge = 0.0;

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next().toUpperCase();
            int hours = scanner.nextInt();
            
            try {
                VehicleType vehicle = VehicleType.valueOf(types[i]);
                charges[i] = vehicle.calculateCharge(hours);
                totalCharge += charges[i];
            } catch (IllegalArgumentException e) {
                charges[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (charges[i] != -1) {
                System.out.printf("%s %.2f\n", types[i], charges[i]);
            } else {
                System.out.printf("%s INVALID\n", types[i]);
            }
        }
        System.out.printf("Total: %.2f\n", totalCharge);
        
        scanner.close();
    }
}