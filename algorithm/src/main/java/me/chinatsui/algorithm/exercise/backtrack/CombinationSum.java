package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-39
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target,
                           int start, int curSum, List<Integer> curList, List<List<Integer>> res) {
        if (curSum == target) {
            res.add(new ArrayList<>(curList));
        } else if (curSum < target) {
            for (int i = start; i < candidates.length; i++) {
                curList.add(candidates[i]);
                backtrack(candidates, target, i, curSum + candidates[i], curList, res);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
