package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        int[][] points = {};
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // for l1
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        // for l2
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode cur = null;
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int num1 = s1.isEmpty() ? 0 : s1.pop();
            int num2 = s2.isEmpty() ? 0 : s2.pop();
            sum += num1 + num2;
            ListNode head = new ListNode(sum % 10);
            head.next = cur;
            cur = head;
            sum /= 10;
        }

        if (sum > 0) {
            ListNode head = new ListNode(sum);
            head.next = cur;
            cur = head;
        }

        return cur;
    }
}
