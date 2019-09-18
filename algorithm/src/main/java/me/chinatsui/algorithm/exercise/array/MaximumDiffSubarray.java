package me.chinatsui.algorithm.exercise.array;

public class MaximumDiffSubarray {

    public int maxDiff(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }

        int max = nums[0], maxCur = max, min = max, minCur = max;
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(max, maxCur);
            minCur = Math.min(minCur + nums[i], nums[i]);
            min = Math.min(min, minCur);
        }

        return max - min;
    }
}
