package me.chinatsui.algorithm.exercise.dp;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int resolve(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        /**
         * dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
         * Because dp[i][j] only depends last row, so we define dp to int[2][m] instead of int[n][m] to save memory.
         */
        int[][] dp = new int[2][m];
        int d1, d2;
        for (int i = 0; i < n; i++) {
            int r1 = i % 2;   // refers to row i;
            int r2 = 1 - r1;  // refers to row i-1;
            for (int j = 0; j < m; j++) {
                dp[r1][j] = grid[i][j];

                // top left corner
                if (i == 0 && j == 0) {
                    continue;
                }

                // down direction
                if (i > 0) {
                    d1 = dp[r2][j];
                } else {
                    d1 = Integer.MAX_VALUE;
                }

                // right direction
                if (j > 0) {
                    d2 = dp[r1][j - 1];
                } else {
                    d2 = Integer.MAX_VALUE;
                }

                dp[r1][j] += Math.min(d1, d2);
            }
        }

        return dp[(n - 1) % 2][m - 1];
    }
}
