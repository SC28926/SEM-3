package array.assignment_problems;

import java.util.Arrays;

public class Subarray {
    public static void main(String[] args) {
        Solutio solution = new Solutio();
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int output = solution.maxSubArray(input);

        System.out.println("Input array: " + Arrays.toString(input));
        System.out.println("Maximum Subarray Sum: " + output);
    }
}

class Solutio {
    int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}