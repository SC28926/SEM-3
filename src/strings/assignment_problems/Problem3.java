package strings.assignment_problems;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = scanner.next();
            }
            
            rotateRoster(names, k);
        }
        
        scanner.close();
    }

    public static void rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        
        String[] rotated = new String[n];
        
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }
        
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(rotated[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}