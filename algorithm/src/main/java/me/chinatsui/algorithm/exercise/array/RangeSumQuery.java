package me.chinatsui.algorithm.exercise.array;

public class RangeSumQuery {

    private int[] sums;

    public RangeSumQuery(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int n = nums.length;
        sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sums == null) {
            return 0;
        }

        if (i > 0) {
            return sums[j] - sums[i - 1];
        } else {
            return sums[j];
        }
    }
}
