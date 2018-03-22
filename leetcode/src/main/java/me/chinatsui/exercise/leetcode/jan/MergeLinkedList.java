package me.chinatsui.exercise.leetcode.jan;

public class MergeLinkedList {

    static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node holder;

        if (head1.data < head2.data) {
            holder = head1;
            head1 = head1.next;
        } else {
            holder = head2;
            head2 = head2.next;
        }

        Node current = holder;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
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

    static Node merge2(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node result;
        if (head1.data < head2.data) {
            result = head1;
            head1 = head1.next;
        } else {
            result = head2;
            head2 = head2.next;
        }

        Node holder = result;
        merge2(holder, head1, head2);
        return result;
    }

    static void merge2(Node holder, Node head1, Node head2) {
        if (head1 == null) {
            holder.next = head2;
        } else if (head2 == null) {
            holder.next = head1;
        } else {
            if (head1.data < head2.data) {
                holder.next = head1;
                head1 = head1.next;
            } else {
                holder.next = head2;
                head2 = head2.next;
            }
            merge2(holder.next, head1, head2);
        }
    }

    static class Node {
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node next;
    }

    public static void main(String[] args) {

        Node h1_1 = new Node(1);
        Node h1_2 = new Node(2);
        Node h1_3 = new Node(2);

        h1_1.next = h1_2;
        h1_2.next = h1_3;

        Node h2_1 = new Node(1);
        Node h2_2 = new Node(7);
        Node h2_3 = new Node(13);

        h2_1.next = h2_2;
        h2_2.next = h2_3;

        Node result = merge2(h2_1, h1_1);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

}
