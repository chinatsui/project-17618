package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public class MinimumSizeContiguousSubarraySum {

    public static void main(String[] args) {
        MinimumSizeContiguousSubarraySum instance = new MinimumSizeContiguousSubarraySum();
        System.out.println(instance.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int minSize = 0;
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                if (minSize == 0) {
                    minSize = i - j + 1;
                } else {
                    minSize = Math.min(minSize, i - j + 1);
                }
                sum -= nums[j++];
            }
        }

        return minSize;
    }

}
