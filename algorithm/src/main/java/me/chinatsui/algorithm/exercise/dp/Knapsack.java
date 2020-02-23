package me.chinatsui.algorithm.exercise.dp;

/**
 * weights[], maxWeight
 */
public class Knapsack {

    public int resolveWithDP(int[] weights, int maxWeight) {
        if (!isValid(weights, maxWeight)) {
            return 0;
        }

        boolean[][] state = new boolean[weights.length][maxWeight + 1];
        state[0][0] = state[0][weights[0]] = true;
        for (int i = 1; i < weights.length; i++) {
            // exclude the item i
            for (int w = 0; w <= maxWeight; w++) {
                if (state[i - 1][w]) {
                    state[i][w] = true;
                }
            }

            // include the item i
            for (int w = 0; w <= maxWeight - weights[i]; w++) {
                if (state[i - 1][w]) {
                    state[i][w + weights[i]] = true;
                }
            }
        }

        for (int w = maxWeight; w >= 0; w--) {
            if (state[weights.length - 1][w]) {
                return w;
            }
        }

        return 0;
    }

    public int resolveWithDP_v2(int[] weights, int maxWeight) {
        if (!isValid(weights, maxWeight)) {
            return 0;
        }

        boolean[] state = new boolean[maxWeight + 1];
        state[0] = state[weights[0]] = true;
        for (int i = 1; i < weights.length; i++) {
            // include the item i, and exclusion of item i is implicitly considered (think it over).
            for (int j = maxWeight - weights[i]; j >= 0; j--) {
                if (state[j]) {
                    state[j + weights[i]] = true;
                }
            }
        }

        for (int w = maxWeight; w >= 0; w--) {
            if (state[w]) {
                return w;
            }
        }

        return 0;
    }

    public int resolveWithBackTracking(int[] weights, int maxWeight) {
        if (!isValid(weights, maxWeight)) {
            return 0;
        }

        int[] res = {-1};
        boolean[][] mem = new boolean[weights.length][maxWeight + 1];
        traceBack(weights, maxWeight, res, mem, 0, 0);
        return res[0];
    }

    private void traceBack(int[] weights, int maxWeight, int[] res,
                           boolean[][] mem, int i, int cw) {
        if (i == weights.length || cw == maxWeight) {
            res[0] = Math.max(res[0], cw);
        } else {
            if (mem[i][cw]) {
                return;
            }

            mem[i][cw] = true;

            // exclude the ith item
            traceBack(weights, maxWeight, res, mem, i + 1, cw);

            // include the ith item if possible
            if (cw + weights[i] <= maxWeight) {
                traceBack(weights, maxWeight, res, mem, i + 1, cw + weights[i]);
            }
        }
    }

    private boolean isValid(int[] weights, int maxWeight) {
        if (weights == null || weights.length < 1) {
            return false;
        }

        if (maxWeight < 0) {
            return false;
        }

        return true;
    }
}
