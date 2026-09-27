package week8hw;

import java.util.Scanner;
import java.util.ArrayList;

interface Customer { 
    double calculateFinalAmount(double amount); 
} 

class Student implements Customer { 
    public double calculateFinalAmount(double amount) { return amount * 0.90; } 
} 

class Staff implements Customer { 
    public double calculateFinalAmount(double amount) { return amount * 0.95; } 
} 

class Guest implements Customer { 
    public double calculateFinalAmount(double amount) { return amount + 10.0; } 
} 

class CustomerFactory { 
    public static Customer getCustomer(String type) { 
        switch (type.toUpperCase()) { 
            case "STUDENT": return new Student(); 
            case "STAFF": return new Staff(); 
            case "GUEST": return new Guest(); 
            default: return null; 
        } 
    }
} 

public class Q1 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        } 
        
        int n = scanner.nextInt(); 
        
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> amounts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) { 
            types.add(scanner.next()); 
            amounts.add(scanner.nextDouble()); 
        } 
        
        double grandTotal = 0; 
        
        for (int i = 0; i < n; i++) {
            String type = types.get(i);
            double amount = amounts.get(i);
            Customer customer = CustomerFactory.getCustomer(type); 
            
            if (customer != null) { 
                double finalAmount = customer.calculateFinalAmount(amount); 
                grandTotal += finalAmount; 
                System.out.printf("%s: %.2f\n", type.toUpperCase(), finalAmount); 
            } 
        }
        
        System.out.printf("Total: %.2f\n", grandTotal); 
        scanner.close(); 
    } 
}