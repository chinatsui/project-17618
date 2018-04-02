package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.HashSet;

public enum AddTwoNumbers {

    INSTANCE;

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        System.out.println(l1);
        System.out.println(l2);
        ListNode result = INSTANCE.addTwoNumbers(l1, l2);
        System.out.println(result);
        new ArrayList(new HashSet());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode holder = null;
        ListNode result = null;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int l1_val = l1.val;
            int l2_val = l2.val;
            int sum = l1_val + l2_val + carry;
            int r_val = sum % 10;
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;

            if (result == null) {
                result = new ListNode(r_val);
                holder = result;
            } else {
                result.next = new ListNode(r_val);
                result = result.next;
            }
        }

        if (l1 == null && l2 == null) {
            result.next = carry > 0 ? new ListNode(carry) : null;
        } else if (l1 == null) {
            concat(result, l2, carry);
        } else if (l2 == null) {
            concat(result, l1, carry);
        }

        return holder;
    }

    private void concat(ListNode result, ListNode node, int carry) {
        while(node != null && carry > 0) {
            int val = node.val;
            int sum = val + carry;
            int r_val = sum % 10;
            carry = sum / 10;
            node = node.next;
            result.next = new ListNode(r_val);
            result = result.next;
        }

        if (node == null && carry > 0) {
            result.next = new ListNode(carry);
        } else if (node != null && carry == 0) {
            result.next = node;
        }
    }

}
