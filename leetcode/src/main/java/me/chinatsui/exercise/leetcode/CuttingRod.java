package me.chinatsui.exercise.leetcode;

/**
 * Created by chinatsui on 13/01/2018.
 */
public class CuttingRod {

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(new CuttingRod().cutting(prices, 8));
    }

    public int cutting(int[] prices, int n) {
        // p = prices.length;
        int p = prices.length;

        // n == 0
        // n == 1
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return prices[n - 1];
        }

        // n >= 2
        // int[] dp
        int[] dp = new int[n];
        dp[0] = prices[0];

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < Math.min(p, i + 1); j++) {
                int left = prices[j];
                int right = i - j - 1 < 0 ? 0 : dp[i - j - 1];
                if (max < left + right) {
                    max = left + right;
                }
            }
            dp[i] = max;
        }

        return dp[n - 1];
    }

}
