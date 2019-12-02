package me.chinatsui.algorithm.exercise.backtrack;

/**
 * Given a string as well as regex, return true if the regex can match string completely, otherwise false.
 * <p>
 * Example:
 * Input: text = "dcdcacvcbcdxx", regex = "a*bcd?xx";
 * Output: 4
 * <p>
 * Assume regex only supports two wildcard symbols: ? and *, so other character match must be equal literally.
 * - ? matches 0 or 1 character.
 * - * matches any number (including 0) of characters.
 */
public class RegexII {

    public boolean match(String text, String pattern) {
        if (text == null || pattern == null || pattern.length() < 1) {
            return false;
        }

        char[] tChars = text.toCharArray(), pChars = pattern.toCharArray();
        return match(tChars, 0, pChars, 0);
    }

    private boolean match(char[] text, int ti, char[] pattern, int pj) {
        if (pj == pattern.length) {
            return ti == text.length;
        }

        if (ti == text.length) {
            if (pattern[pj] == '*' || pattern[pj] == '?') {
                return match(text, ti, pattern, pj + 1);
            } else {
                return false;
            }
        }

        if (pattern[pj] == '*') {
            for (int k = ti; k <= text.length; k++) {
                if (match(text, k, pattern, pj + 1)) {
                    return true;
                }
            }
        } else if (pattern[pj] == '?') {
            return match(text, ti, pattern, pj + 1) || match(text, ti + 1, pattern, pj + 1);
        } else if (ti < text.length && text[ti] == pattern[pj]) {
            return match(text, ti + 1, pattern, pj + 1);
        }

        return false;
    }
}
