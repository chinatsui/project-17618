package me.chinatsui.algorithm.exercise.linkedlist;

/**
 * LeetCode - 138
 * <p>
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class CopyList {

    public Node deepCopy(Node head) {
        Node cur = head;

        // link copy node to the old linked list.
        while (cur != null) {
            Node copy = new Node(cur.val);
            Node next = cur.next;
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        // link random pointer.
        cur = head;
        while (cur != null) {
            Node random = cur.random;
            Node copy = cur.next;
            if (random != null) {
                copy.random = random.next;
            }
            cur = copy.next;
        }

        // restore old linked list to construct deep copy of old linked list.
        cur = head;
        Node dummy = new Node(0);
        Node dummyCur = dummy;
        while (cur != null) {
            Node copy = cur.next;
            dummyCur.next = copy;
            dummyCur = copy;
            cur.next = copy.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    private static class Node {
        private int val;
        private Node next;
        private Node random;

        Node(int _val) {
            val = _val;
        }
    }
}
