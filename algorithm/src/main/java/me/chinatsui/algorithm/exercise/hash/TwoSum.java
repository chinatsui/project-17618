package me.chinatsui.algorithm.exercise.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. TwoSum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                res[0] = cache.get(nums[i]);
                res[1] = i;
            } else {
                cache.putIfAbsent(target - nums[i], i);
            }
        }
        return res;
    }
}
