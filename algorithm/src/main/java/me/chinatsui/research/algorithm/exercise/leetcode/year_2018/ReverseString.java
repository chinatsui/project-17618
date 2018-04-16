package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum ReverseString {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.reverseString("hello"));
    }

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
