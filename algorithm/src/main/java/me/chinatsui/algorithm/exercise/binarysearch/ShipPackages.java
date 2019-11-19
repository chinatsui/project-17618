package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * LeetCode 1011 - Capacity To Ship Packages Within D Days
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 * <p>
 * The i-th package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages
 * on the conveyor belt being shipped within D days.
 * <p>
 * Example 1:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14
 * and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * <p>
 * Example 2:
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation:
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * <p>
 * Example 3:
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * <p>
 * Note:
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
public class ShipPackages {

    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = 0;
        for (int weight : weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }

        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (suffice(weights, D, mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return lo;
    }

    private boolean suffice(int[] weights, int D, int cap) {
        int days = 1;
        int load = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (load + weights[i] > cap) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return days <= D;
    }
}
