package me.chinatsui.algorithm.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ThreeSum {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        System.out.println(INSTANCE.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int twoSum = nums[i] + nums[j];
                int comp = Arrays.binarySearch(nums, j + 1, nums.length, -twoSum);
                if (comp > j) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[comp]);
                    res.add(cur);
                }
            }
        }

        return res;
    }

}
