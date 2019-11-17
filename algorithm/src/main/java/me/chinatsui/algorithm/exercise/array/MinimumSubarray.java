package me.chinatsui.algorithm.exercise.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the smallest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: -5
 * Explanation: [-5] has the smallest sum = -5.
 * <p>
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution
 * using the divide and conquer approach, which is more subtle.
 */
public class MinimumSubarray {

    public int minSum(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int res = nums[0], cur = res;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.min(cur + nums[i], nums[i]);
            res = Math.min(res, cur);
        }

        return res;
    }
}
