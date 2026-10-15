package string.class_problems;

import java.util.Scanner;

public class Reverse {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null || customerName.isEmpty()) {
            return customerName;
        }
        
        StringBuilder reversed = new StringBuilder(customerName);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Original name: ");
    	String a = sc.next();
        String reversedName = reverseCustomerName(a);
        
        System.out.println("Reversed Name: " + reversedName);
        
        sc.close();
    }
}