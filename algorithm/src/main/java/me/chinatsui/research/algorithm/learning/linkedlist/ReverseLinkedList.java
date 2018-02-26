package me.chinatsui.research.algorithm.learning.linkedlist;


public class ReverseLinkedList {

    public static void main(String[] args) {
        Node h1_1 = new Node(1);
        Node h1_2 = new Node(2);
        Node h1_3 = new Node(3);
        Node h1_4 = new Node(4);
        Node h1_5 = new Node(5);
        Node h1_6 = new Node(6);

        h1_1.next = h1_2;
        h1_2.next = h1_3;
        h1_3.next = h1_4;
        h1_4.next = h1_5;
        h1_5.next = h1_6;

        new ReverseLinkedList().reverse(h1_1);

        while (h1_6 != null) {
            System.out.println(h1_6.data);
            h1_6 = h1_6.next;
        }

    }


    public void reverse(Node current) {

        if (current.next == null) {
            return;
        }

        if (current.next.next == null) {
            Node next = current.next;
            next.next = current;
            return;
        }

        Node prev = current;
        current = current.next;
        Node next = current.next;
        prev.next = null;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        return;
    }

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
