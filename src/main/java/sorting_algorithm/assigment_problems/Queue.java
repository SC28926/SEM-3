package sorting_algorithm.assigment_problems;

import java.util.Scanner;

public class Queue {
    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "");
            if (!line.isEmpty()) {
                String[] parts = line.split("[,\\s]+");
                int[] tokens = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    tokens[i] = Integer.parseInt(parts[i]);
                }
                System.out.println(firstBreak(tokens));
            }
        }
        scanner.close();
    }
}