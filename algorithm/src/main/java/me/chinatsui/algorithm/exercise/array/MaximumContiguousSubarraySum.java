package me.chinatsui.algorithm.exercise.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array and a target number, please find the maximum contiguous sub array in which the sum equals to target.
 *
 * Example:
 * Input: nums = {4, 3, 2, 4, 1, 1, 2, 3, 1, -1, -4, 7, 9, 15, 16, 1, -1}, target = 9
 * Output: 9
 * Explanation: We can get the sub array = {2, 4, 1, 1, 2, 3, 1, -1, -4}, its length is 9.
 */
public class MaximumContiguousSubarraySum {

    public int getMaxLength(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int length = nums[0] == target ? 1 : 0;
        int curSum = nums[0];
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(curSum, 0);
        for (int i = 1; i < nums.length; i++) {
            curSum += nums[i];

            int sumDiff = curSum - target;
            if (cache.containsKey(sumDiff)) {
                length = Math.max(i - cache.get(sumDiff), length);
            }

            if (!cache.containsKey(curSum)) {
                cache.put(curSum, i);
            }
        }

        return length;
    }
}
