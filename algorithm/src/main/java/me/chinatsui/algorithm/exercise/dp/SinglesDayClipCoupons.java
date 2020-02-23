package me.chinatsui.algorithm.exercise.dp;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * prices[], coupon bound
 */
public class SinglesDayClipCoupons {

    int times = 3;

    public int[] resolve(int[] prices, int couponBound) {
        if (!isValid(prices, couponBound)) {
            return new int[]{};
        }

        int n = prices.length;
        int bound = times * couponBound;
        boolean[][] dp = new boolean[n][bound + 1];
        dp[0][0] = dp[0][prices[0]] = true;

        for (int i = 1; i < n; i++) {
            // exclusion
            for (int p = 0; p <= bound; p++) {
                if (dp[i - 1][p]) {
                    dp[i][p] = true;
                }
            }

            // inclusion
            for (int p = 0; p <= bound - prices[i]; p++) {
                if (dp[i - 1][p]) {
                    dp[i][p + prices[i]] = true;
                }
            }
        }

        int closest = couponBound;
        for (; closest <= bound; closest++) {
            if (dp[n - 1][closest]) {
                break;
            }
        }

        // there is no answers for total price less and equals n times of coupon, so return.
        if (closest == bound + 1) {
            return new int[]{};
        }

        // select item to shopping list.
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 1; i--) {
            if (closest >= prices[i] && dp[i - 1][closest - prices[i]]) {
                res.add(prices[i]);
                closest -= prices[i];
            }
        }

        if (closest > 0) {
            res.add(prices[0]);
        }

        return IntStream.range(0, res.size()).map(i -> res.get(i)).toArray();
    }


    private boolean isValid(int[] prices, int couponBound) {
        if (prices == null || prices.length < 1) {
            return false;
        }

        if (couponBound < 1) {
            return false;
        }

        return true;
    }
}
