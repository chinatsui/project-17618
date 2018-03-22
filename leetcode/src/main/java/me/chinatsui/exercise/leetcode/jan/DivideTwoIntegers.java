package me.chinatsui.exercise.leetcode.jan;

/**
 * Created by chinatsui on 13/01/2018.
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(2147483647, 2));
    }

    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int top = dividend;

        boolean foundTop = false;
        while (!foundTop) {
            int sum = 0;
            for (int i = 1; i <= divisor; i++) {
                sum = sum + top;
                if (sum > dividend) {
                    break;
                }
            }
            if (sum == dividend) {
                return purgeResult(top, isNegative);
            } else if (sum > dividend) {
                top = top >> 1;
            } else {
                foundTop = true;
            }
        }

        int bottom = top;
        top = top << 1;

        while (bottom < top) {
            int middle = (bottom + top) >> 1;
            int sum = 0;
            for (int i = 1; i <= divisor; i++) {
                sum = sum + middle;
                if (sum > dividend) {
                    break;
                }
            }

            if (sum == dividend) {
                return purgeResult(middle, isNegative);
            } else if (sum < dividend) {
                bottom = middle + 1;
            } else {
                top = middle - 1;
            }

        }

        int sum = 0;
        for (int i = 1; i <= divisor; i++) {
            sum = sum + bottom;
            if (sum > dividend) {
                bottom = bottom - 1;
                return purgeResult(bottom, isNegative);
            }
        }

        return purgeResult(bottom, isNegative);
    }

    private int purgeResult(int input, boolean isNegative) {
        int result = isNegative ? 0 - input : input;
        if (!isNegative && result == -2147483648) {
            return 2147483647;
        } else {
            return result;
        }
    }

}
