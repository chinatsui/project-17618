package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode-24
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

    public ListNode swap(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;

        int i = 0;
        while (head.next != null) {
            head = head.next;
            i++;

            if (i % 2 == 1) {
                ListNode headNext = head.next;
                ListNode prevNext = prev.next;
                prev.next = head;
                head.next = prevNext;
                prevNext.next = headNext;
                prev = prevNext;
                head = prevNext;
            }
        }

        return dummy.next;
    }
}
