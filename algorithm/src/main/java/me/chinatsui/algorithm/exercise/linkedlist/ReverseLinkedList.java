package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;

/**
 * Input: dummy -> a1 -> a2 -> a3 -> a4
 * Output: dummy -> a4 -> a3 -> a2 -> a1
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(Solution.INSTANCE.reverse(head));
    }

    public enum Solution {
        INSTANCE;

        public ListNode reverse(ListNode head) {
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
}
