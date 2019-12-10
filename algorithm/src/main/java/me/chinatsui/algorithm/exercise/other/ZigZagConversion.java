package me.chinatsui.algorithm.exercise.other;

/**
 * LeetCode 6. ZigZag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * <p>
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        // as many as nRows
        StringBuilder[] rows = new StringBuilder[nRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0, n = s.length();
        char[] c = s.toCharArray();
        while (i < n) {
            for (int idx = 0; idx < nRows && i < n; idx++) // vertically down
                rows[idx].append(c[i++]);

            for (int idx = nRows - 2; idx >= 1 && i < n; idx--) // obliquely up
                rows[idx].append(c[i++]);
        }

        for (int idx = 1; idx < rows.length; idx++)
            rows[0].append(rows[idx]);

        return rows[0].toString();
    }
}
