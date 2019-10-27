package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode - 361, LintCode - 553
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 *
 * The bomb kills all the enemies in the same row and column
 * from the planted point until it hits the wall since the wall is too strong to be destroyed.
 *
 * Note: You can only put the bomb at an empty cell.
 *
 * Example1
 *
 * Input:
 * grid =[
 *      "0E00",
 *      "E0WE",
 *      "0E00"
 * ]
 * Output: 3
 * Explanation:
 * Placing a bomb at (1,1) kills 3 enemies
 *
 * Example2
 *
 * Input:
 * grid =[
 *      "0E00",
 *      "EEWE",
 *      "0E00"
 * ]
 * Output: 2
 * Explanation:
 * Placing a bomb at (0,0) or (0,3) or (2,0) or (2,3) kills 2 enemies
 */
public class BombEnemy {

    public int maxKilled(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        /* dp[i][j] refers to how many enemies in one direction can be killed by a bomb put at grid[i][j]
         *
         * For example of up direction by put a bomb:
         *             {
         *               0, if grid[i][j] is the wall
         * dp[i][j] =    dp[i-1][j] + 1, if grid[i][j] is the enemy, the +1 here is used for next row calculation.
         *               dp[i-1][j], if grid[i][j] is empty
         *             }
         */
        int[][] dp = new int[n][m];

        // res[i][j] is the accumulation of dp[i][j] for four directions.
        int[][] res = new int[n][m];

        // up
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;

                if (grid[i][j] == 'W') {
                    continue;
                }

                if (grid[i][j] == 'E') {
                    dp[i][j] = 1;
                }

                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                res[i][j] += dp[i][j];
            }
        }

        // down
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;

                if (grid[i][j] == 'W') {
                    continue;
                }

                if (grid[i][j] == 'E') {
                    dp[i][j] = 1;
                }

                if (i + 1 < n) {
                    dp[i][j] += dp[i + 1][j];
                }

                res[i][j] += dp[i][j];
            }
        }

        // left
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;

                if (grid[i][j] == 'W') {
                    continue;
                }

                if (grid[i][j] == 'E') {
                    dp[i][j] = 1;
                }

                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }

                res[i][j] += dp[i][j];
            }
        }

        // right
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = 0;

                if (grid[i][j] == 'W') {
                    continue;
                }

                if (grid[i][j] == 'E') {
                    dp[i][j] = 1;
                }

                if (j + 1 < m) {
                    dp[i][j] += dp[i][j + 1];
                }

                res[i][j] += dp[i][j];
            }
        }

        // final result, only grid[i][j] == '0', we can use for final result comparison.
        int maxKilled = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    maxKilled = Math.max(maxKilled, res[i][j]);
                }
            }
        }

        return maxKilled;
    }
}
