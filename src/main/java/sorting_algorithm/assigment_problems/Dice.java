package sorting_algorithm.assigment_problems;

import java.util.Arrays;

public class Dice {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        
        for (int roll : rolls) {
            count[roll]++;
        }
        
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + (i < 6 ? " " : "\n"));
        }
        
        int[] sorted = new int[rolls.length];
        int index = 0;
        
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        
        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        
        int[] sortedRolls = diceSort(rolls);
        
        System.out.println("Sorted: " + Arrays.toString(sortedRolls));
    }
}