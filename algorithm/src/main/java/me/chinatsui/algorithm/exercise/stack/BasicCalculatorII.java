package me.chinatsui.algorithm.exercise.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * LeetCode 227. Basic Calculator II
 * <priorities>
 * Implement a basic calculator to evaluate a simple expression string.
 * <priorities>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * <priorities>
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 * <priorities>
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 * <priorities>
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 * <priorities>
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {

    private static HashMap<Character, Integer> priorities = new HashMap<>();

    static {
        priorities.put('+', 1);
        priorities.put('-', 2);
        priorities.put('*', 3);
        priorities.put('/', 3);
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                continue;
            }

            // push num
            int num = 0;
            while (i < ch.length && (isDigit(ch[i]) || ch[i] == ' ')) {
                if (isDigit(ch[i])) {
                    num = num * 10 + (ch[i] - '0');
                }
                i++;
            }
            nums.push(num);

            // if current operator is not prior to last one, do calculation for last two numbers with last operator
            while (i < ch.length && !ops.isEmpty() && !isPrior(ch[i], ops.peek())) {
                Integer num2 = nums.pop();
                Integer num1 = nums.pop();
                char op = ops.pop();
                nums.push(calculate(num1, num2, op));
            }

            // push operator
            if (i < ch.length) {
                ops.push(ch[i]);
            }
        }

        // do calculate for rest numbers with operators of the same priority
        while (!ops.isEmpty()) {
            Integer num2 = nums.pop();
            Integer num1 = nums.pop();
            char op = ops.pop();
            nums.push(calculate(num1, num2, op));
        }

        return nums.pop();
    }

    private boolean isDigit(char ch) {
        int diff = ch - '0';
        return 0 <= diff && diff <= 9;
    }

    private boolean isPrior(char op1, char op2) {
        return priorities.get(op1) > priorities.get(op2);
    }

    private int calculate(Integer num1, Integer num2, char op) {
        switch (op) {
            case '*':
                return (num1 * num2);
            case '/':
                return (num1 / num2);
            case '+':
                return (num1 + num2);
            default:
                return (num1 - num2);
        }
    }
}
