package sorting_algorithm.class_problems;

public class Search {
    public static int searchInsertPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        System.out.println(searchInsertPosition(nums1, 5));

        System.out.println();

        int[] nums2 = {1, 3, 5, 6};
        System.out.println(searchInsertPosition(nums2, 2));
    }
}