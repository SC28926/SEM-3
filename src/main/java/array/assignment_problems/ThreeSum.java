package array.assignment_problems;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Sol s = new Sol();
        int[] input = {-1, 0, 1, 2, -1, -4};
        int[][] output = s.threeSum(input);

        System.out.println("Input array: " + Arrays.toString(input));
        System.out.println("Three Sum Triplets: " + Arrays.deepToString(output));
    }
}

class Sol {
    int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{
                        nums[i], nums[left], nums[right]
                    });

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}