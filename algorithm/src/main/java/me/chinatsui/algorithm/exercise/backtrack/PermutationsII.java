package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        List<List<Integer>> res = Solution.INSTANCE.permuteUnique(nums);
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums); // Don't forget this, it is necessary
            backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
            return res;
        }

        private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] isUsed) {
            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i] || i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                    continue;
                }
                isUsed[i] = true;
                cur.add(nums[i]);
                backtrack(res, cur, nums, isUsed);
                cur.remove(cur.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
