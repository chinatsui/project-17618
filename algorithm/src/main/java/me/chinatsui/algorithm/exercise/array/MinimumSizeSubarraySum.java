package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode-209
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int minSize = -1, sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            // maybe here can be optimized by binary search.
            while (sum >= s) {
                if (minSize == -1) {
                    minSize = i - j + 1;
                } else {
                    minSize = Math.min(minSize, i - j + 1);
                }
                sum -= nums[j++];
            }
        }

        return minSize;
    }
}
