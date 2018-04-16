package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;


import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        for (int num : nums) {
            List<Integer> root = new ArrayList<>();
            root.add(num);
            int[] remains = getRemains(nums, num);
            permute(results, root, remains);
        }

        return results;
    }

    private void permute(List<List<Integer>> results, List<Integer> root, int[] remains) {
        // no remaining, so put result
        if (remains.length == 0) {
            results.add(root);
        }

        for (Integer remain : remains) {
            List<Integer> newRoot = new ArrayList<>();
            newRoot.addAll(root);
            newRoot.add(remain);
            int[] newRemains = getRemains(remains, remain);
            permute(results, newRoot, newRemains);
        }
    }

    private int[] getRemains(int[] nums, int removed) {
        int[] remains = new int[nums.length - 1];

        for (int i = 0, j = 0; i < remains.length; i++, j++) {
            if (nums[j] == removed) {
                remains[i] = nums[++j];
            } else {
                remains[i] = nums[j];
            }
        }
        return remains;
    }

}
