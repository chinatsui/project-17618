package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode-2
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1), cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int num1 = l1.val;
            int num2 = l2.val;
            int sum = num1 + num2 + carry;
            int num = sum % 10;
            carry = sum / 10;

            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            processRestNodes(cur, l1, carry);
        } else if (l2 != null) {
            processRestNodes(cur, l2, carry);
        } else if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }

    private void processRestNodes(ListNode cur, ListNode tail, int carry) {
        while (tail != null) {
            int sum = carry + tail.val;
            int num = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            tail = tail.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
    }
}