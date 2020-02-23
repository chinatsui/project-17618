package me.chinatsui.algorithm.exercise.stack;

import java.util.Stack;

public class MaxStack {
    private Stack<Integer> s = new Stack<>();
    private Integer max;

    // Prints maximum element of MyStack
    public Integer getMax() {
        if (s.empty()) {
            return null;
        } else {
            return max;
        }
    }

    // Prints top element of MyStack
    public Integer peek() {
        if (s.empty()) {
            return null;
        }

        int t = s.peek(); // Top element.
        return t > max ? max : t;
    }

    // Remove the top element from MyStack
    public Integer pop() {
        if (s.empty()) {
            return null;
        }

        int res = max;
        int t = s.pop();
        // Maximum will change as the maximum element
        // of the stack is being removed.
        if (t > max) {
            max = 2 * max - t;
        }

        return res;
    }

    void push(int x) {
        // Insert new number into the stack
        if (s.empty()) {
            max = x;
            s.push(x);
            return;
        }

        // If new number is greater than max
        if (x > max) {
            s.push(2 * x - max);
            max = x;
        } else {
            s.push(x);
        }
    }
}
