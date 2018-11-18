package me.chinatsui.algorithm.exercise.linked_list;

import me.chinatsui.algorithm.util.ListNode;

public enum RotateList {

    INSTANCE;

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        INSTANCE.rotateRight(node, 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode tail = null;
        int n = 0;

        // reverse the whole
        while (head != null) {
            n++;
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        head = tail;

        k = k % n;
        // reverse 0...k%n
        tail = null;
        int i = 0;
        while (i < k) {
            i++;
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        ListNode left = tail;
        tail = null;

        // reverse k%n...n
        while (k < n) {
            k++;
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }

        if (left != null) {
            ListNode result = left;
            while (left.next != null) {
                left = left.next;
            }

            left.next = tail;

            return result;
        } else {
            return tail;
        }

    }

}
