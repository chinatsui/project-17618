package me.chinatsui.algorithm.exercise.backtrack;

import java.util.Objects;

/**
 * Assume pattern only supports two wildcard symbol: ? and *, so other character match must be equal literally.
 *  - ? matches 0 or 1 character.
 *  - * matches any number (including 0) of characters.
 */
public class RegexPattern {

    private final char[] pattern;
    private final int pLen;

    public RegexPattern(String regex) {
        Objects.requireNonNull(regex);
        pattern = regex.toCharArray();
        pLen = regex.length();
    }

    public int match(String text) {
        char[] charSeq = text.toCharArray();
        int tLen = text.length();

        //TODO: We can use KMP solution to enhance below brute-force iteration.
        for (int i = 0; i < tLen; i++) {
            if (match(charSeq, i, 0)) {
                return i;
            }
        }

        return -1;
    }

    private boolean match(char[] charSeq, int ti, int pj) {
        if (pj == pLen) {
            return true;
        } else {
            if (pattern[pj] == '*') {
                int k = charSeq.length - ti;
                for (int j = 0; j <= k; j++) {
                    if (match(charSeq, ti + j, pj + 1)) {
                        return true;
                    }
                }
            } else if (pattern[pj] == '?') {
                if (match(charSeq, ti, pj + 1)) {
                    return true;
                }
                return match(charSeq, ti + 1, pj + 1);
            } else if (pattern[pj] == charSeq[ti]) {
                return match(charSeq, ti + 1, pj + 1);
            }
            return false;
        }
    }
}
