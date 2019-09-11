package me.chinatsui.algorithm.exercise.string;

/**
 * LeetCode-8
 * <p>
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found.
 * <p>
 * Then, starting from this character, takes an optional initial plus or minus sign followed by
 * as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * <p>
 * Example 1:
 * Input: "42"
 * Output: 42
 * <p>
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * <p>
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * <p>
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * <p>
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */
public class Atoi {

    public int convert(String str) {
        if (str == null) {
            return 0;
        }

        int result = 0;
        boolean isPos = true;

        str = str.trim();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0 && (c == '+' || c == '-')) {
                isPos = c == '+';
            } else if (c >= '0' && c <= '9') {
                if (isOverFlow(result, c)) {
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                break;
            }
        }

        return isPos ? result : -result;
    }

    private boolean isOverFlow(int result, char c) {
        if (Integer.MAX_VALUE / 10 == result && c - '0' > 7) {
            return true;
        } else if (Integer.MAX_VALUE / 10 < result) {
            return true;
        } else {
            return false;
        }
    }
}
