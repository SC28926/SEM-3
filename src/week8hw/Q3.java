package week8hw;

import java.util.Scanner;

enum RoomType {
    SINGLE {
        double calculateBill(int units, int extraParam) {
            return units * 8.0;
        }
    },
    SHARED {
        double calculateBill(int units, int occupants) {
            return (units * 6.0) / occupants;
        }
    },
    AC {
        double calculateBill(int units, int extraParam) {
            return (units * 10.0) + 200.0;
        }
    };

    abstract double calculateBill(int units, int extraParam);
}

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        
        String[] originalTypes = new String[n];
        double[] bills = new double[n];
        double grandTotal = 0.0;
        
        for (int i = 0; i < n; i++) {
            String typeInput = scanner.next();
            originalTypes[i] = typeInput;
            
            RoomType type = RoomType.valueOf(typeInput.toUpperCase());
            int units = scanner.nextInt();
            
            int extraParam = 0;
            if (type == RoomType.SHARED) {
                extraParam = scanner.nextInt();
            }
            
            double bill = type.calculateBill(units, extraParam);
            bills[i] = bill;
            grandTotal += bill;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f\n", originalTypes[i], bills[i]);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        
        scanner.close();
    }
}