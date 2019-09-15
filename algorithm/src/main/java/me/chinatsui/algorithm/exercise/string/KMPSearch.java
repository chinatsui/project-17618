package me.chinatsui.algorithm.exercise.string;

/**
 * KMP algorithm, O(n+m).
 */
public class KMPSearch extends StringSearch {

    public int search(char[] text, char[] pattern) {
        validate(text, pattern);
        int n = text.length, m = pattern.length;
        int[] next = generateNextAux(pattern);

        int j = 0;
        for (int i = 0; i < n; i++) {
            // when not matched, calculate next offset
            while (j > 0 && text[i] != pattern[j]) {
                j = next[j - 1] + 1;
            }

            if (text[i] == pattern[j]) {
                j++;
            }

            if (j == m) {
                return i - m + 1;
            }
        }

        return -1;
    }

    private int[] generateNextAux(char[] pattern) {
        int m = pattern.length;
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && pattern[k + 1] != pattern[i]) {
                k = next[k];
            }
            if (pattern[k + 1] == pattern[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    @Override
    void checkUnsupportedChar(char[] seq) {
    }
}
