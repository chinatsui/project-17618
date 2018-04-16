package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.List;

public enum SubSets {

    INSTANCE;

    boolean[] isUsed = new boolean[3];

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = INSTANCE.subsets(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList();
        List<Integer> used = new ArrayList();
        track(nums, 0, used, res);
        return res;
    }

    private void track(int[] nums, int start, List<Integer> used, List<List<Integer>> res) {
        res.add(new ArrayList<>(used));
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]) {
                continue;
            }
            isUsed[i] = true;
            used.add(nums[i]);
            track(nums, i + 1, used, res);
            isUsed[i] = false;
            used.remove(used.size() - 1);
        }
    }

}
