package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode 486. Predict the Winner
 * <p>
 * Given an array of scores that are non-negative integers.
 * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
 * Each time a player picks a number, that number will not be available for the next player.
 * This continues until all the scores have been chosen. The player with the maximum score wins.
 * <p>
 * Given an array of scores, predict whether player 1 is the winner.
 * You can assume each player plays to maximize his score.
 * <p>
 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 * <p>
 * Example 2:
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 * <p>
 * Note:
 * 1 <= length of the array <= 20.
 * Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 * If the scores of both players are equal, then player 1 is still the winner.
 */
public class PredictWinner {

    /**
     * Note: This question is same with LeetCode 877. Stone Game
     */
    public boolean predictTheWinner(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int n = nums.length;

        // dp[i][j] = Math.max(sum[i...j] - dp[i + 1][j], sum[i...j] - dp[i][j-1]);
        // Explanation:
        // If player1 choose nums[i], then the player2 can picks up max sum is dp[i+1][j],
        // so player1 can get sum[i...j] - dp[i+1][j]
        // Otherwise, If palyer1 choose nums[j], then the player2 can picks up max sum is dp[i][j-1];
        // so player1 can get sum[i...j] - dp[i][j-1]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        int sum = 0;
        for (int end = 1; end < n; end++) {
            sum = nums[end];
            for (int start = end - 1; start >= 0; start--) {
                sum += nums[start];
                dp[start][end] = Math.max(sum - dp[start + 1][end], sum - dp[start][end - 1]);
            }
        }

        // as long as Player 1 can get scores equals to or larger than half of sum[0...n-1]
        return dp[0][n - 1] * 2 >= sum;
    }
}
