package strings.class_problems;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        int sum = 0;
        int reverse = 0;
        int temp = number;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reverse = (reverse * 10) + digit;
            temp /= 10;
        }
        
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        
        scanner.close();
    }
}