package me.chinatsui.algorithm.exercise.string;

public class ReverseII {

    public String reverse(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (!isAlphabet(chars[i])) {
                i++;
            }

            while (!isAlphabet(chars[j])) {
                j--;
            }

            if (i >= j) {
                break;
            }

            char tmp = chars[j];
            chars[j] = chars[i];
            chars[i] = tmp;

            i++;
            j--;
        }

        return new String(chars);
    }

    private boolean isAlphabet(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }
}
