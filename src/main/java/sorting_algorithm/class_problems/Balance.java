package sorting_algorithm.class_problems;

import java.util.Arrays;

public class Balance {
    public static int[] pairSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        int[] result1 = pairSumSorted(nums1, 4);
        if (result1 != null) {
            System.out.println("(" + result1[0] + ", " + result1[1] + ")");
        } else {
            System.out.println("Not Found");
        }
        System.out.println();
        
        int[] nums2 = {1, 2, 3};
        int[] result2 = pairSumSorted(nums2, 100);
        if (result2 != null) {
            System.out.println("(" + result2[0] + ", " + result2[1] + ")");
        } else {
            System.out.println("Not Found");
        }
    }
}