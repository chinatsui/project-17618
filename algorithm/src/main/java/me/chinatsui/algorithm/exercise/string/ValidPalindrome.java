package me.chinatsui.algorithm.exercise.string;

/**
 * LeetCode-125
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    public boolean check(String str) {
        if (str == null) {
            return false;
        }

        if (str.length() <= 1) {
            return true;
        }

        char[] ch = str.toCharArray();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(ch[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(ch[j])) {
                j--;
            } else {
                if (Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j])) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
}
