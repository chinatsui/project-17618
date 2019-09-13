package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode-46
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> cur, Set<Integer> visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int num : nums) {
                if (!visited.contains(num)) {
                    cur.add(num);
                    visited.add(num);
                    permute(nums, res, cur, visited);
                    visited.remove(num);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
