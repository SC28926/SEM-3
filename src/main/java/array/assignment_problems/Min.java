package array.assignment_problems;

import java.util.Arrays;

public class Min {
    public static void main(String[] args) {
        Minimum solution = new Minimum();
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int output = solution.findMin(input);

        System.out.println("Input array: " + Arrays.toString(input));
        System.out.println("Minimum element: " + output);
    }
}

class Minimum {
    int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}