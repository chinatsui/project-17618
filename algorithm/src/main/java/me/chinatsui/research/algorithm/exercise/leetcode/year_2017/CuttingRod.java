package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;

/**
 * Created by chinatsui on 13/01/2018.
 */
public class CuttingRod {

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(new CuttingRod().cutting(prices, 20));
    }

    public int cutting(int[] prices, int n) {
        // n == 0
        if (n == 0) {
            return 0;
        }

        // n == 1
        if (n == 1) {
            return prices[n - 1];
        }

        // n >= 2
        int[] dp = new int[n];
        dp[0] = prices[0];

        for (int i = 1; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < Math.min(prices.length, i + 1); j++) {
                int left = prices[j];
                int right = i - j - 1 < 0 ? 0 : dp[i - j - 1];
                cur = Math.max(cur, left + right);
            }
            dp[i] = cur;
        }

        return dp[n - 1];
    }

}
