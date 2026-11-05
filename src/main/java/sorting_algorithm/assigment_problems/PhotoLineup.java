package sorting_algorithm.assigment_problems;

import java.util.Arrays;
public class PhotoLineup {
public static void lineUp(int[] heights) {
int n = heights.length;
int pass = 1;
for (int i = 0; i < n - 1; i++) {
boolean swapped = false;
for (int j = 0; j < n - 1 - i; j++) {
if (heights[j] > heights[j + 1]) {
int temp = heights[j];
heights[j] = heights[j + 1];
heights[j + 1] = temp;
swapped = true;
}
}
System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
pass++;
if (!swapped) {
break;
}
}
}
public static void main(String[] args) {
System.out.println("--- Test Case 1 ---");
int[] heights1 = {4, 2, 5, 1};
lineUp(heights1);
System.out.println("\n--- Test Case 2 ---");
int[] heights2 = {1, 3, 2, 4};
lineUp(heights2);
}
}