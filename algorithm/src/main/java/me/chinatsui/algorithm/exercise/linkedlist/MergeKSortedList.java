package me.chinatsui.algorithm.exercise.linkedlist;


import me.chinatsui.algorithm.entity.ListNode;

/**
 * LeetCode - 23
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList extends MergeTwoSortedList {

    public ListNode merge(ListNode[] nodes) {
        if (nodes == null || nodes.length < 1) {
            return null;
        }

        return partition(nodes, 0, nodes.length - 1);
    }

    private ListNode partition(ListNode[] nodes, int start, int end) {
        if (start == end) {
            return nodes[start];
        } else {
            int mid = start + (end - start) / 2;
            ListNode left = partition(nodes, start, mid);
            ListNode right = partition(nodes, mid + 1, end);
            return merge(left, right);
        }
    }
}
