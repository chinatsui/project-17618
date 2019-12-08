package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode-53
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution
 * using the divide and conquer approach, which is more subtle.
 */
public class MaximumSumSubarray {

    public int maxSum(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int res = nums[0], cur = res;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            res = Math.max(res, cur);
        }

        return res;
    }
}
