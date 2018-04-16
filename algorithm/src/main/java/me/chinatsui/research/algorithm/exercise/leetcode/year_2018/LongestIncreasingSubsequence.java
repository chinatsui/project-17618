package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.Arrays;

public enum LongestIncreasingSubsequence {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(INSTANCE.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int length = 0;

        for (int x : nums) {
            int r = Arrays.binarySearch(dp, 0, length, x);
            if (r < 0) {
                r = -(r + 1);
            }
            dp[r] = x;
            if (r == length) {
                length++;
            }
        }

        return length;
    }

}
