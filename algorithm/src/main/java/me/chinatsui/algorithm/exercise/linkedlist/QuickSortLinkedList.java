package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

public class QuickSortLinkedList {

    public static void main(String[] args) {
        QuickSortLinkedList qsl = new QuickSortLinkedList();
        ListNode head = ListNodes.deserialize(new int[]{19, 54, 18, 26, 13, 9, 7});
        qsl.sort(head);
        System.out.println(0);
    }

    public void sort(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        partition(head, tail);
    }

    private void partition(ListNode start, ListNode end) {
        if (start == end || start == null || end == null || end.next == start) {
            return;
        }

        ListNode sm = start, cur = start, prev = null;
        while (cur != end) {
            if (cur.val < end.val) {
                int tmp = cur.val;
                cur.val = sm.val;
                sm.val = tmp;
                prev = sm;
                sm = sm.next;
            }
            cur = cur.next;
        }

        int tmp = sm.val;
        sm.val = end.val;
        end.val = tmp;

        partition(start, prev);
        partition(sm.next, end);
    }
}
