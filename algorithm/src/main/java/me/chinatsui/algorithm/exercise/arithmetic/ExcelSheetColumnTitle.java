package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 168. Excel Sheet Column Title
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * Input: 1
 * Output: "A"
 * <p>
 * Example 2:
 * Input: 28
 * Output: "AB"
 * <p>
 * Example 3:
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {

    private static char[] map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }

        String res = "";
        n--;
        while (n >= 0) {
            res = map[n % 26] + res;
            n = n / 26 - 1;
        }

        return res;
    }
}
