package me.chinatsui.algorithm.exercise.string;

/**
 * LeetCode 567. Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString pis = new PermutationInString();
        System.out.println(pis.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        int l1 = s1.length(), l2 = s2.length();

        if (l1 > l2) {
            return false;
        }

        for (int i = 0; i < l2 - l1 + 1; i++) {
            if (isAnagram(s1, s2.substring(i, i + l1))) {
                return true;
            }
        }

        return false;
    }

    private boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
