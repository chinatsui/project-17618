package me.chinatsui.algorithm.exercise.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * Input: 3
 * Output: "III"
 * <p>
 * Example 2:
 * Input: 4
 * Output: "IV"
 * <p>
 * Example 3:
 * Input: 9
 * Output: "IX"
 * <p>
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    private final static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }

    public String resolve(int num) {
        int scale = 1;
        String res = "";
        while (num > 0) {
            int n = num % 10;
            if (0 < n && n < 4) {
                for (int i = 1; i <= n; i++) {
                    res = map.get(scale) + res;
                }
            } else if (n == 4) {
                res = map.get(scale) + map.get(scale * 5) + res;
            } else if (n == 5) {
                res = map.get(scale * 5) + res;
            } else if (5 < n && n < 9) {
                for (int i = 6; i <= n; i++) {
                    res = map.get(scale) + res;
                }
                res = map.get(scale * 5) + res;
            } else if (n == 9) {
                res = map.get(scale) + map.get(scale * 10) + res;
            }
            num /= 10;
            scale *= 10;
        }

        return res;
    }
}
