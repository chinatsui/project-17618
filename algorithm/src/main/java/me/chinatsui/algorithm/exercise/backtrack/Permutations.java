package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = Solution.INSTANCE.permute(nums);
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(new ArrayList(), res, nums, new boolean[nums.length]);
            return res;
        }

        private void backtrack(ArrayList<Integer> cur, List<List<Integer>> res, int[] nums, boolean[] isUsed) {
            if (cur.size() == nums.length) {
                res.add(new ArrayList(cur));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (!isUsed[i]) {
                        cur.add(nums[i]);
                        isUsed[i] = true;
                        backtrack(cur, res, nums, isUsed);
                        isUsed[i] = false;
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
    }
}
