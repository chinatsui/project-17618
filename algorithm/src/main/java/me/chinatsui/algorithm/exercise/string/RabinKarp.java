package me.chinatsui.algorithm.exercise.string;

/**
 * For easy understanding, we assume text and pattern only supports character between a...z.
 * This solution makes use of 26-scale to form a hash value.
 * <p>
 * To detect if text contains pattern, we only compares hash value
 * for each comparision between text's substring and pattern.
 */
public class RabinKarp extends StringSearch {

    public int search(char[] text, char[] pattern) {
        validate(text, pattern);

        int n = text.length, m = pattern.length;
        double s1_hash = 0, s2_hash = 0;
        for (int i = 0; i < m; i++) {
            s1_hash += (text[i] - 'a') * Math.pow(26, m - i - 1);
            s2_hash += (pattern[i] - 'a') * Math.pow(26, m - i - 1);
        }

        if (s1_hash == s2_hash) {
            return 0;
        }

        /**
         * To calculate the hash value of substrings of s1, we can always use last value to calculate current value.
         * Assume h(i-1) represents last hash value, h(i) represents current hash value, then we can have:
         *    h(i-1) = 26^(m-1)*(charAt[i-1] - 'a') + 26^(m)*(charAt[i] - 'a') + ... + 26^(0)*(charAt[i + m - 2] - 'a')
         *    h(i) =                                  26^(m-1)*(charAt[i] - 'a') + ... + 26^(0)*(charAt[i + m - 1] - 'a')
         *    h(i) = (h(i-1) - 26^(m-1)*(charAt[i-1] - 'a')) * 26 + 26^(0)*(charAt[i + m - 1] - 'a')
         */
        for (int i = 1; i < n - m + 1; i++) {
            s1_hash = (s1_hash - ((text[i - 1] - 'a') * Math.pow(26, m - 1))) * 26 + (text[i + m - 1] - 'a');
            if (s1_hash == s2_hash) {
                return i;
            }
        }

        return -1;
    }

    protected boolean containsUnsupportedChar(char[] str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] < 'a' || str[i] > 'z') {
                return true;
            }
        }
        return false;
    }
}
