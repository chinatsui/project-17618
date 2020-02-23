package me.chinatsui.algorithm.exercise.string;

/**
 * LeetCode 402. Remove K Digits
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number
 * is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * <p>
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * <p>
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * <p>
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {

    public String removeKDigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k > 0) {
            for (int i = 0; i < sb.length(); i++) {
                if (i + 1 < sb.length() && sb.charAt(i) > sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    break;
                }

                if (i == sb.length() - 1) {
                    sb.deleteCharAt(i);
                }
            }
            k--;
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
