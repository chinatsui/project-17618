package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.Stack;

public enum ValidParentheses {

    INSTANCE;

    public static void main(String[] args) {
    }

    public boolean isValid(String s) {

        // }{
        // {[]}
        // ()[]{}
        // (]
        // ([)]
        // {()}

        if (s == null) {
            return false;
        }

        char[] ch = s.toCharArray();
        int n = ch.length;

        if (n % 2 > 0) {
            return false;
        }

        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(ch[i]);
            } else {
                char prev = (char)stack.pop();
                if (prev == '(' && ch[i] == ')') {
                    continue;
                } else if (prev == '{' && ch[i] == '}') {
                    continue;
                } else if (prev == '[' && ch[i] == ']') {
                    continue;
                } else {
                    stack.push(prev);
                    stack.push(ch[i]);
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }

}
