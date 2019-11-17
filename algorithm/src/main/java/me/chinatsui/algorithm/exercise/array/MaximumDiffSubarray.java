package me.chinatsui.algorithm.exercise.array;

/**
 * Given an integer array nums, find its maximum contiguous subarray and minimum contiguous subarray.
 * Return the difference between the two sub arrays.
 *
 * Example:
 * Input: nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * Output: 10
 * Explanation:
 * Minimum contiguous subarray = {-2, 1, -3}, sum = -4
 * Maximum contiguous subarray = {4, -1, 2, 1}, sum = 6
 * So, return 6 - (-4) = 10
 */
public class MaximumDiffSubarray {

    public int maxDiff(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int max = nums[0], maxCur = max, min = max, minCur = max;
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(max, maxCur);
            minCur = Math.min(minCur + nums[i], nums[i]);
            min = Math.min(min, minCur);
        }

        return max - min;
    }
}
