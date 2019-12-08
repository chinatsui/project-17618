package me.chinatsui.algorithm.exercise.string;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length < 1) {
            return 0;
        }

        int i = 0, j = 0, n = chars.length;
        while (j < n) {
            char cur = chars[j];
            int cnt = 0;
            while (j < n && chars[j] == cur) {
                j++;
                cnt++;
            }
            chars[i++] = cur;
            if (cnt > 1) {
                for (char ch : Integer.toString(cnt).toCharArray()) {
                    chars[i++] = ch;
                }
            }
        }

        return i;
    }
}
