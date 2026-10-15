package array.assignment_problems;

import java.util.Arrays;

public class Product {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 2, 3, 4};
        int[] output = solution.productExceptSelf(input);

        System.out.println("Input array:  " + Arrays.toString(input));
        System.out.println("Output array: " + Arrays.toString(output));
    }
}

class Solution { 
    public int[] productExceptSelf(int[] nums) { 
        int n = nums.length; 
        int[] answer = new int[n]; 
        int product = 1; 
        
        for (int i = 0; i < n; i++) { 
            answer[i] = product; 
            product *= nums[i]; 
        } 
        
        product = 1; 
        for (int i = n - 1; i >= 0; i--) { 
            answer[i] *= product; 
            product *= nums[i]; 
        } 
        
        return answer; 
    } 
}
