package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode 121. Best Time to Buy and Sell Stock
 */
public class BestBuyAndSell {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(prices[i] - min, profit);
            }
        }

        return profit;
    }
}
