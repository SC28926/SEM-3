package strings.class_problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.next();
        
        String reversed = new StringBuilder(original).reverse().toString();
        
        if (original.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
        
        scanner.close();
    }
}
