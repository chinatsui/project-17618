package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode-25
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {

    public ListNode reverse(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;

        int i = 0;
        while (head.next != null) {
            head = head.next;
            i++;

            if ((i + 1) % k == 0) {
                ListNode next = head.next;
                head.next = null;
                ListNode prevNext = prev.next;
                prev.next = reverse(prev.next);
                prevNext.next = next;
                prev = prevNext;
                head = prevNext;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }

        return dummy.next;
    }
}
