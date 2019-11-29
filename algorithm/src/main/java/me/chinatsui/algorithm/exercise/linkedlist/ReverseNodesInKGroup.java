package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode 25. Reverse Nodes in k-Group
 * <p>
 * Given a linked list, reverse k nodes of the linked list at a time and return its modified list.
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
public class ReverseNodesInKGroup extends ReverseLinkedList {

    public ListNode reverse(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;

        int cnt = 1;
        while (head != null) {
            head = head.next;
            cnt++;

            if (cnt % k == 0 && head != null) {
                ListNode headNext = head.next;
                head.next = null;
                ListNode prevNext = prev.next;
                prev.next = reverse(prevNext);
                prevNext.next = headNext;
                prev = prevNext;
                head = headNext;
                cnt++;
            }
        }

        return dummy.next;
    }
}
