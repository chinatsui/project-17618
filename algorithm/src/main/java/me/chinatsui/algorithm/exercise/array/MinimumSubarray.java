package me.chinatsui.algorithm.exercise.array;

public class MinimumSubarray {

    public int minSum(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int res = nums[0], cur = res;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.min(cur + nums[i], nums[i]);
            res = Math.min(res, cur);
        }

        return res;
    }
}
