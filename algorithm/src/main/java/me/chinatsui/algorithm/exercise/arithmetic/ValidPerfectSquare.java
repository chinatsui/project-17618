package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 367. Valid Perfect Square
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num % 10 == 2 || num % 10 == 3 || num % 10 == 7 || num % 10 == 8) {
            return false;
        }

        int lo = 1, hi = num;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int res = num / mi, tail = num % mi;

            if (res == mi && tail == 0) {
                return true;
            } else if (res > mi) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return false;
    }
}
