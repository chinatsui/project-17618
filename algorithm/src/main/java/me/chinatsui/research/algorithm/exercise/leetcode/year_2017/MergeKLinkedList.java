package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;


public class MergeKLinkedList {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int h) {

        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        if (lists.length == 2) {
            return merge(lists[0], lists[1]);
        }

        int m = (h + l) / 2;
        // doLeft
        ListNode leftNode = mergeKLists(lists, l, m);
        // doRight
        ListNode rightNode = mergeKLists(lists, m + 1, h);
        // merge
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode holder;
        if (head1.val < head2.val) {
            holder = head1;
            head1 = head1.next;
        } else {
            holder = head2;
            head2 = head2.next;
        }

        ListNode current = holder;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 == null) {
            current.next = head2;
        } else {
            current.next = head1;
        }

        return holder;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
