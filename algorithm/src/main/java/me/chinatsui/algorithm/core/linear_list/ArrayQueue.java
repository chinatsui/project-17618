package me.chinatsui.algorithm.core.linear_list;

/**
 * The implementation is a bounded array queue.
 */
public class ArrayQueue<T> implements Queue<T> {

    private Object[] elements;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int n) {
        elements = new Object[n];
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public boolean offer(T val) {
        if (size() == elements.length) {
            return false;
        }

        int i = tail % elements.length;
        elements[i] = val;
        tail++;
        return true;
    }

    @Override
    public T poll() {
        if (size() == 0) {
            return null;
        }

        return (T) elements[head++];
    }
}
