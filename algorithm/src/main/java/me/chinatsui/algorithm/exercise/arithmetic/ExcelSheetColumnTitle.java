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

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();

        char[] chars = new char[26];
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            chars[ch - 'A'] = ch;
        }

        n--;
        while (n >= 0) {
            builder.append(chars[n % 26]);
            n = n / 26 - 1;
        }

        return builder.reverse().toString();
    }
}
