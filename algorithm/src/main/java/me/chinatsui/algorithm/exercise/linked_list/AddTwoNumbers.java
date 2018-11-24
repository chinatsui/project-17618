package me.chinatsui.algorithm.exercise.linked_list;

import me.chinatsui.algorithm.util.ListNode;

public class AddTwoNumbers {
    /*
     LeetCode-2

     You are given two non-empty linked lists representing two non-negative integers.
     The digits are stored in reverse order and each of their nodes contain a single digit.
     Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example:
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = Solution.INSTANCE.addTwoNumbers(l1, l2);
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            int sum = 0;
            while (l1 != null && l2 != null) {
                int val1 = l1.val;
                int val2 = l2.val;
                sum += val1 + val2;
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = cur.next;
                sum /= 10;
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode l3 = l1 != null ? l1 : l2;
            while (l3 != null) {
                int val3 = l3.val;
                sum += val3;
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = cur.next;
                sum /= 10;
                l3 = l3.next;
            }

            if (sum > 0) {
                ListNode node = new ListNode(sum);
                cur.next = node;
            }

            return dummy.next;
        }
    }
}