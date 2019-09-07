package me.chinatsui.algorithm.exercise.string;

public class BoyerMoore extends StringSearch {

    public int search(char[] text, char[] pattern) {
        validate(text, pattern);
        int n = text.length, m = pattern.length;

        // used for "Bad character rule"
        int[] positions = hashPattern(pattern);

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
                return i; // Pattern matched, so return search.
            }

            int bcMove = j - positions[(int) text[i + j]]; // the move steps of bad character rule.

            int gsMove = 0; // the move steps of good suffix rule.
            if (j < m - 1) {
                gsMove = getMoveByGS(j, m, prefix, suffix);
            }

            i += Math.max(bcMove, gsMove);
        }

        return -1;
    }

    private int[] hashPattern(char[] pattern) {
        int[] pos = new int[128]; // Let's only consider ASCII characters.
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }

        for (int i = 0; i < pattern.length; i++) {
            pos[(int) pattern[i]] = i;
        }

        return pos;
    }

    private void populatePrefixSuffix(char[] pattern, boolean[] prefix, int[] suffix) {
        int m = pattern.length;
        for (int i = 0; i < m; i++) {
            prefix[i] = false;
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
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        } else {
            for (int r = j + 2; r < m - 1; r++) {
                if (prefix[m - r]) {
                    return r;
                }
            }
            return m;
        }
    }

    @Override
    boolean containsUnsupportedChar(char[] seq) {
        for (int i = 0; i < seq.length; i++) {
            if (((int) seq[i]) > 127) {
                return true;
            }
        }
        return false;
    }
}
