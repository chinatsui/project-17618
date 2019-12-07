package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode 45 - Jump Game II
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Note: You can assume that you can always reach the last index.
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        // dp[i] refers to the minimum steps to reach i.
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int next = Math.min(i + j, n - 1);
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}
