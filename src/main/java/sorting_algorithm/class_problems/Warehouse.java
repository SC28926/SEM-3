package sorting_algorithm.class_problems;

import java.util.Map;

public class Warehouse {

    public static class SummaryResult {
        public int total;
        public int[] maxCoordinate;

        public SummaryResult(int total, int[] maxCoordinate) {
            this.total = total;
            this.maxCoordinate = maxCoordinate;
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, new int[]{0, 0});
        }

        int totalItems = 0;
        int maxItems = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int currentValue = grid[r][c];
                totalItems += currentValue;

                if (currentValue > maxItems) {
                    maxItems = currentValue;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new SummaryResult(totalItems, new int[]{maxRow, maxCol});
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        SummaryResult result = warehouseSummary(grid);
        System.out.println("total = " + result.total + ", maxCoordinate = (" + result.maxCoordinate[0] + ", " + result.maxCoordinate[1] + ")");
    }
}