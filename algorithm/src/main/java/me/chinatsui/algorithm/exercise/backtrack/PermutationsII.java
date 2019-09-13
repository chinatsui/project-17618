package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode-47
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, res, new ArrayList<>(), visited);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                    continue;
                }

                cur.add(nums[i]);
                visited[i] = true;
                permute(nums, res, cur, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
