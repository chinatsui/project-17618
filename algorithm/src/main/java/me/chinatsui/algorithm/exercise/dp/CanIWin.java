package me.chinatsui.algorithm.exercise.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 464. Can I Win
 *
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * The player who first causes the running total to reach or exceed 100 wins.
 *
 * What if we change the game so that players cannot re-use integers?
 *
 * For example, two players might take turns drawing from a common pool of numbers of 1..15
 * without replacement until they reach a total >= 100.
 *
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player
 * to move can force a win, assuming both players play optimally.
 *
 * You can always assume that maxChoosableInteger will not be larger than 20
 * and desiredTotal will not be larger than 300.
 *
 * Example
 *
 * Input:
 * maxChoosableInteger (mci) = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 */
public class CanIWin {

    public boolean canIWin(int mci, int desiredTotal) {
        if (mci * (mci + 1) / 2 <desiredTotal) {
            return false;
        }

        if (desiredTotal <= 0) {
            return true;
        }

        return canIWin(desiredTotal, new int[mci], new HashMap<>());
    }

    /**
     * Why the "cache" doesn't consider "total"? Because total is related to chosen number, as long as we cache the state
     * of chosen numbers, naturally "total" is considered.
     * Why we need to use cache? Because player2 might re-do the same choices, so we can directly give the answer at
     * that time.
     */
    private boolean canIWin(int remain, int[] state, HashMap<String, Boolean> cache) {
        // state stores the state of what numbers are chosen, use toString() as key
        String key = Arrays.toString(state);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                int chosen = i + 1;
                // Two cases:
                // 1. Player1 chooses the number causes total exceeds, so win.
                // 2. Player2's chosen result is false, so player1 win.
                if (chosen >= remain || !canIWin(remain - chosen, state, cache)) {
                    state[i] = 0;
                    cache.put(key, true);
                    return true;
                }
                state[i] = 0;
            }
        }

        cache.put(key, false);
        return false;
    }
}
