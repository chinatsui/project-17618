package me.chinatsui.algorithm.core.linear_list;

public class LinkedQueue<T> implements Queue<T> {

    private LinkedNode head;
    private LinkedNode tail;
    private int count;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean offer(T val) {
        LinkedNode node = new LinkedNode(val);

        if (tail == null) {
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = tail.next;
        }

        if (head == null) {
            head = tail;
        }

        count++;
        return true;
    }

    @Override
    public T poll() {
        if (head == null) {
            return null;
        } else {
            T val = (T) head.val;
            LinkedNode prev = head;
            head = head.next;

            // avoid memory leak
            if (head != null) {
                head.prev = null;
            }
            prev.next = null;

            count--;
            return val;
        }
    }
}
