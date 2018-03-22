package me.chinatsui.exercise.leetcode.jan;

/**
 * Created by chinatsui on 13/01/2018.
 */
public class HouseRobber {

    /*
     * dp(n) = Math.max(dp(n-1), dp(n-2) + A[n]);
     */

    public long houseRobber(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }

        if (A.length == 2) {
            return Math.max(A[0], A[1]);
        }

        int n = A.length;

        long result = 0;
        long dp_n_2 = A[0];
        long dp_n_1 = A[1];

        for (int i = 2; i < n; i++) {
            result = Math.max(dp_n_1, dp_n_2 + A[i]);
            dp_n_2 = dp_n_1;
            dp_n_1 = result;
        }

        return result;
    }

}
