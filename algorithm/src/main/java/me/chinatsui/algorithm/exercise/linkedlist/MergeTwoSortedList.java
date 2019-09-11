package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode-21
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {

    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }

        if (h2 == null) {
            return h1;
        }

        ListNode dummy = new ListNode(0), cur = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        if (h1 != null) {
            cur.next = h1;
        } else if (h2 != null) {
            cur.next = h2;
        }

        return dummy.next;
    }
}
