package strings.assignment_problems;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }
            
            System.out.println(secondHighest(scores));
        }
        
        scanner.close();
    }

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second && score < highest) {
                second = score;
            }
        }
        
        return second;
    }
}