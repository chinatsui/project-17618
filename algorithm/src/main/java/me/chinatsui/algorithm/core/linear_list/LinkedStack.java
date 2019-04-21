package me.chinatsui.algorithm.core.linear_list;

public class LinkedStack<T> implements Stack<T> {

    private LinkedNode tail;
    private int count;

    @Override
    public int size() {
        return count;
    }

    @Override
    public void push(T val) {
        if (val == null) {
            return;
        }

        if (tail == null) {
            tail = new LinkedNode(val);
        } else {
            LinkedNode linkedNode = new LinkedNode(val);
            linkedNode.prev = tail;
            tail.next = linkedNode;
            tail = tail.next;
        }
        count++;
    }

    @Override
    public T pop() {
        if (tail == null) {
            return null;
        } else {
            T val = (T) tail.val;
            LinkedNode last = tail;
            tail = tail.prev;

            // avoid memory leak
            last.prev = null;
            if (tail != null) {
                tail.next = null;
            }

            count--;
            return val;
        }
    }
}
