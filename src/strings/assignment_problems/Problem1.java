package strings.assignment_problems;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] grid = new int[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            
            busiestRow(grid);
        }
        
        scanner.close();
    }

    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int busiestIndex = 0;
        
        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }
            
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                busiestIndex = i;
            }
        }
        
        System.out.println("Row " + busiestIndex + ", Total " + maxTotal);
    }
}