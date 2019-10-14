package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode-322
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

    public int resolve(int[] coins, int amount) {
        if (coins == null || coins.length < 1 || amount < 0) {
            return -1;
        }

        /*
         * dp[i] = min(dp[i - coins[0]] + 1, dp[i - coins[1]] + 1, ..., dp[i - coins[len-1]] + 1)
         */
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        return dp[amount];
    }
}
