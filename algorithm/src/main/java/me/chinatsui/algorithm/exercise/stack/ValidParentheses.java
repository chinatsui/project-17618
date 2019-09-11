package me.chinatsui.algorithm.exercise.stack;

import java.util.Stack;

/**
 * LeetCode-20
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String parentheses) {
        if (parentheses == null || parentheses.length() < 1) {
            return true;
        }

        int n = parentheses.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char cur = parentheses.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char prev = stack.pop();
                if (cur == ')' && prev == '(') {
                    continue;
                } else if (cur == ']' && prev == '[') {
                    continue;
                } else if (cur == '}' && prev == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.size() < 1;
    }
}
