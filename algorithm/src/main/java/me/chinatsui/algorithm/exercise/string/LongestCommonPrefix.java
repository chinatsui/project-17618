package me.chinatsui.algorithm.exercise.string;

/**
 * LeetCode 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int lo, int hi) {
        if (lo == hi) {
            return strs[lo];
        }

        int mi = lo + (hi - lo) / 2;
        String prefixLeft = longestCommonPrefix(strs, lo, mi);
        String prefixRight = longestCommonPrefix(strs, mi + 1, hi);

        return getCommonPrefix(prefixLeft, prefixRight);
    }

    private String getCommonPrefix(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }

        int minLen = Math.min(s1.length(), s2.length());
        int prefix = -1;
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            prefix++;
        }

        return s1.substring(0, prefix + 1);
    }
}
