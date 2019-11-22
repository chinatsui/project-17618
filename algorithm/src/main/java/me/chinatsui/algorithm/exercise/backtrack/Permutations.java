package me.chinatsui.algorithm.exercise.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46 - Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        }
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                cur.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, cur, res);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
