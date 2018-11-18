package me.chinatsui.algorithm.exercise.dp;

public enum BestBuyAndSell {

    INSTANCE;

    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(INSTANCE.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        int profit = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++ ) {
                profit = Math.max(profit, doTransaction(prices[i], prices[j]));
            }
        }

        return profit;
    }

    private int doTransaction(int buy, int sell) {
        return sell - buy < 0 ? 0 : sell - buy;
    }

}
