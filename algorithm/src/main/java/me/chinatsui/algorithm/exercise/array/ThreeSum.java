package me.chinatsui.algorithm.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode-15
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4], a solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> resolve(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, n - 1, -nums[i]);
            for (List<Integer> list : twoSumRes) {
                ArrayList<Integer> subRes = new ArrayList<>(list);
                subRes.add(nums[i]);
                res.add(subRes);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                res.add(Arrays.asList(nums[start], nums[end]));
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
