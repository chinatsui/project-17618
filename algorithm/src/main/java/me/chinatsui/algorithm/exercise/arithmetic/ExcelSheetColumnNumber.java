package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 171. Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int n = s.length();
        double check = Math.pow(26, n - 1);

        if (check > Integer.MAX_VALUE) {
            return 0;
        }

        int res = 0, pow = (int)check;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            res += (chars[i] - 'A' + 1) * pow;
            pow /= 26;
        }

        return res;
    }
}
