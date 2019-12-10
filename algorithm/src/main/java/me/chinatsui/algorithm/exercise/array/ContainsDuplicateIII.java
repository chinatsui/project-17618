package me.chinatsui.algorithm.exercise.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 220. Contains Duplicate III
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
 * between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 1 || t < 0) {
            return false;
        }

        int groupSize = t + 1;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                cache.remove(getGroup(nums[i - k - 1], groupSize));
            }

            int group = getGroup(nums[i], groupSize);

            if (cache.containsKey(group)) {
                return true;
            }

            if (cache.containsKey(group - 1) && Math.abs(cache.get(group - 1) - nums[i]) < groupSize) {
                return true;
            }

            if (cache.containsKey(group + 1) && Math.abs(cache.get(group + 1) - nums[i]) < groupSize) {
                return true;
            }

            cache.put(group, nums[i]);
        }

        return false;
    }

    private int getGroup(int num, int size) {
        int group = num / size;
        return num < 0 ? --group : group;
    }
}
