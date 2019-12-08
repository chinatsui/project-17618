package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode 152. Maximum Product Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * <p>
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        System.out.println(mps.maxProduct(new int[]{-1, -2, -9, -6}));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
