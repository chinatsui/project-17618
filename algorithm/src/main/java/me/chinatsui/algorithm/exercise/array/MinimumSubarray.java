package me.chinatsui.algorithm.exercise.array;

public enum MinimumSubarray {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(INSTANCE.minSubArray(nums));
    }

    public int minSubArray(int[] nums) {
        int local = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            local = Math.min(nums[i], nums[i] + local);
            global = Math.min(global, local);
        }

        return global;
    }

}
