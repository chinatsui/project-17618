package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum MaximumSubarray {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {2, -1, -2, 1, -4, 2, 8};
        System.out.println(INSTANCE.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int local = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i] + local, nums[i]);
            global = Math.max(global, local);
        }

        return global;
    }

}
