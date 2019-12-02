package me.chinatsui.algorithm.exercise.string;

public class Reverse {

    public String reverseString(String s) {
        if (s == null) {
            return null;
        }

        int start = 0;
        int end = s.length() - 1;

        char[] ch = s.toCharArray();

        while (start < end) {
            char temp = ch[end];
            ch[end] = ch[start];
            ch[start] = temp;
            start++;
            end--;
        }

        return new String(ch);
    }
}
