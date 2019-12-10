package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode 122. Best Time to Buy and Sell Stock II
 */
public class BestBuyAndSell2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }
}
