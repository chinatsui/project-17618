package me.chinatsui.algorithm.exercise.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Boyer Moore algorithm.
 */
public class BMSearch extends StringSearch {

    public int search(char[] text, char[] pattern) {
        validate(text, pattern);
        int n = text.length, m = pattern.length;

        // used for "Bad character rule"
        Map<Character, Integer> bcMap = hashPattern(pattern);

        // used for "Good suffix rule"
        boolean[] prefix = new boolean[m];
        int[] suffix = new int[m];
        populatePrefixSuffix(pattern, prefix, suffix);

        int i = 0;
        while (i < n - m + 1) {
            int j = m - 1;
            for (; j >= 0; j--) {
                if (text[i + j] != pattern[j]) { // Found difference, break the loop.
                    break;
                }
            }

            if (j < 0) {
                return i; // Pattern matched, so return contains.
            }

            int bcMove = j - bcMap.getOrDefault(text[i + j], -1); // the move steps of bad character rule.

            int gsMove = 0; // the move steps of good suffix rule.
            if (j < m - 1) {
                gsMove = getMoveByGS(j, m, prefix, suffix);
            }

            i += Math.max(bcMove, gsMove);
        }

        return -1;
    }

    private Map<Character, Integer> hashPattern(char[] pattern) {
        Map<Character, Integer> bcMap = new HashMap<>();
        for (int i = 0; i < pattern.length; i++) {
            bcMap.put(pattern[i], i);
        }

        return bcMap;
    }

    private void populatePrefixSuffix(char[] pattern, boolean[] prefix, int[] suffix) {
        int m = pattern.length;
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
        }

        for (int i = 0; i < m - 1; i++) {
            int j = i, k = 0;

            while (j >= 0 && pattern[j] == pattern[m - 1 - k]) {
                suffix[++k] = j--;
            }

            if (j < 0) {
                prefix[k] = true;
            }
        }
    }

    private int getMoveByGS(int j, int m, boolean[] prefix, int[] suffix) {
        int k = m - 1 - j;

        // find another suffix
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }

        // find prefix
        for (int r = j + 2; r < m - 1; r++) {
            if (prefix[m - r]) {
                return r;
            }
        }

        // has neither suffix nor prefix
        return m;
    }

    @Override
    void checkUnsupportedChar(char[] seq) {
        for (int i = 0; i < seq.length; i++) {
            if (((int) seq[i]) > 127) {
                throw new IllegalArgumentException();
            }
        }
    }
}
