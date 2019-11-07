package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode-92
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII extends ReverseLinkedList {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;

        ListNode start = null, end = start;
        for (int i = 1; i <= n; i++) {
            if (i == m) {
                start = head;
            }

            if (i == n) {
                end = head;
            }

            if (start == null) {
                prev = head;
            }

            head = head.next;
        }

        ListNode endNext = end.next;
        end.next = null;

        prev.next = reverse(start);
        start.next = endNext;

        return dummy.next;
    }
}
