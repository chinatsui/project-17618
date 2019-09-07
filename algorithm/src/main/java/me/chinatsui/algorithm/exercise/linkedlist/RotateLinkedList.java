package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        System.out.println(Solution.INSTANCE.rotateRight(node, 2));
    }

    public enum Solution {
        INSTANCE;

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
}
