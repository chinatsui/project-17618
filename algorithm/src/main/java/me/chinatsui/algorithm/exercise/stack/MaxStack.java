package me.chinatsui.algorithm.exercise.stack;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> s = new Stack<Integer>();
    Integer max;

    // Driver Code
    public static void main(String[] args) {
        MaxStack s = new MaxStack();
        s.push(3);
        s.push(5);
        System.out.println("Max: " + s.getMax());
        s.push(7);
        s.push(19);
        System.out.println("Max: " + s.getMax());
        System.out.println("Pop: " + s.pop());
        System.out.println("Max: " + s.getMax());
        System.out.println("Pop: " + s.pop());
        System.out.println("Peek: " + s.peek());
    }

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
