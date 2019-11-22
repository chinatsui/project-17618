package me.chinatsui.algorithm.exercise.backtrack;

/**
 * Given a string as well as regex, return the index of first place where the regex match one substring.
 * <p>
 * Example:
 * Input: text = "dcdcacvcbcdxx", regex = "a*bcd?xx";
 * Output: 4
 * <p>
 * Assume regex only supports two wildcard symbols: ? and *, so other character match must be equal literally.
 * - ? matches 0 or 1 character.
 * - * matches any number (including 0) of characters.
 */
public class Regex {

    public int match(String text, String pattern) {
        if (text == null || pattern == null || pattern.length() < 1) {
            return -1;
        }

        char[] tChars = text.toCharArray(), pChars = pattern.toCharArray();

        // Note: we can make use of KMP thought for optimization, here just iterates the each letter to start match.
        for (int i = 0; i < text.length(); i++) {
            if (match(tChars, i, pChars, 0)) {
                return i;
            }
        }

        return -1;
    }

    private boolean match(char[] text, int ti, char[] pattern, int pj) {
        if (pj == pattern.length) {
            return true;
        }

        // pattern is longer than text
        if (ti == text.length && (pattern[pj] == '*' || pattern[pj] == '?')) {
            return match(text, ti, pattern, pj + 1);
        }

        if (pattern[pj] == '*') {
            for (int k = ti; k < text.length; k++) {
                if (match(text, k, pattern, pj + 1)) {
                    return true;
                }
            }
        } else if (pattern[pj] == '?') {
            return match(text, ti, pattern, pj + 1) || match(text, ti + 1, pattern, pj + 1);
        } else if (ti < text.length && pattern[pj] == text[ti]) {
            return match(text, ti + 1, pattern, pj + 1);
        }

        return false;
    }
}
