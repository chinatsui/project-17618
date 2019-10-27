package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode - 256
 * <p>
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * <p>
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on...
 * <p>
 * Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length < 1 || costs[0].length < 1) {
            return 0;
        }

        /**
         * dp[i][0] = min(dp[i-1][1] + costs[i-1][0], dp[i-1][2] + costs[i-1][0])
         * dp[i][0] means the min cost of first i houses and the last house (i-1) is painted with color red.
         */
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        // init
        for (int i = 1; i <= n; i++) {
            // j is the color painted to the last house handled in dp[i][j]
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                // k is the color painted to the last house handled in dp[i-1][k]
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                }
            }
        }

        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }
}
