package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;

/**
 * Created by chinatsui on 13/01/2018.
 */
public class PaintFence {

    /*
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */

    /*
     *   dp(n) = dp(n-1) * (k-1) + dp(n-2) * (k-1)
     */

    public int numWays(int n, int k) {
        if (k == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int[] dp = new int[n];

        dp[0] = k;
        dp[1] = dp[0] * (k - 1) + k;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }

        return dp[n - 1];
    }

}
