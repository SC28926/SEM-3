package array.assignment_problems;

import java.util.*;

public class KSum {
    public static void main(String[] args) {
        Sum solution = new Sum();
        int[] input = {1, 1, 1};
        int k = 2;
        int output = solution.subarraySum(input, k);

        System.out.println("Input array: " + Arrays.toString(input));
        System.out.println("Target sum (k): " + k);
        System.out.println("Total subarrays: " + output);
    }
}

class Sum {
    int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            count += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}