package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

/**
 * LeetCode 25. Reverse Nodes in k-Group's follow-up
 * <p>
 * Given a linked list, start from the end node to reverse k nodes of the linked list
 * at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the start should remain as it is.
 * <p>
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 1->3->2->5->4
 * For k = 3, you should return: 1->2->5->4->3
 * <p>
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroupII extends ReverseNodesInKGroup {

    public ListNode reverseFromEnd(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        int n = ListNodes.length(head), offset = n % k;
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        while (offset > 0) {
            prev = head;
            head = head.next;
            offset--;
        }

        prev.next = reverse(head, k);
        return dummy.next;
    }
}
