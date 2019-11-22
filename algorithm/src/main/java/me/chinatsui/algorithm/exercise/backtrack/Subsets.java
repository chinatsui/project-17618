package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 78 - Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
