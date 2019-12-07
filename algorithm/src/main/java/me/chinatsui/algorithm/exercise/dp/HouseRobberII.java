package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode 213. House Robber II
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 *
 * Example 2:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {

    public int robHouse(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        if (lo + 1 == hi) {
            return Math.max(nums[lo], nums[hi]);
        }

        int[] dp = new int[hi - lo + 1];
        dp[0] = nums[lo];
        dp[1] = Math.max(nums[lo], nums[lo + 1]);

        for (int i = lo + 2; i <= hi; i++) {
            int j = i - lo;
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[i]);
        }

        return dp[hi - lo];
    }
}
