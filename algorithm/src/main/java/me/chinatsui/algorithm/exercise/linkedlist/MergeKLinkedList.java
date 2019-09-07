package me.chinatsui.algorithm.exercise.linkedlist;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import me.chinatsui.algorithm.entity.ListNode;

public class MergeKLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(18);
        head1.next.next = new ListNode(28);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(65);

        ListNode head3 = new ListNode(6);
        head3.next = new ListNode(4);

        ListNode merged = Solution.INSTANCE.mergeKLists(new ListNode[]{head1, head2, head3});

        System.out.println(merged);
    }

    public enum Solution {
        INSTANCE;

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }

            Queue<ListNode> queue = new LinkedList<>(Arrays.asList(lists));
            while (queue.size() > 1) {
                ListNode head1 = queue.poll();
                ListNode head2 = queue.poll();
                ListNode merged = merge(head1, head2);
                queue.offer(merged);
            }

            return queue.poll();
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
    }
}
