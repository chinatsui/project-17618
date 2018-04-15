package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PermutationsII {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = INSTANCE.permuteUnique(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] isUsed) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i] || i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) continue;
                isUsed[i] = true;
                cur.add(nums[i]);
                backtrack(res, cur, nums, isUsed);
                isUsed[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

}
