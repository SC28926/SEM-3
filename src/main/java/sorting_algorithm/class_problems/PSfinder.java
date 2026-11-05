package sorting_algorithm.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PSfinder {
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> complements = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (complements.contains(complement)) {
                return true;
            }
            complements.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSum(nums1, 9) + " (2 + 7 = 9)");
        System.out.println();
        System.out.println(hasPairWithSum(nums2, 20));
    }
}