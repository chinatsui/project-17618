package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 131 - Palindrome Partitioning
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if (s != null && s.length() > 0) {
            partition(s, 0, new ArrayList<>(), res);
        }

        return res;
    }

    private void partition(String s, int start, List<String> cur, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    cur.add(s.substring(start, end + 1));
                    // partition rest part
                    partition(s, end + 1, cur, res);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
