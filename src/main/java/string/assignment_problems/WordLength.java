package string.assignment_problems;

import java.util.*;
public class WordLength {
    static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() >= 1 && word.length() <= 4)
                shortWords++;
            else if (word.length() <= 8)
                mediumWords++;
            else
                longWords++;
        }
        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie review: ");
        String review = sc.nextLine();
        classifyWordLengths(review);
        sc.close();
    }
}