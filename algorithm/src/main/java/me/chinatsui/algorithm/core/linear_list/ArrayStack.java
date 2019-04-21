package me.chinatsui.algorithm.core.linear_list;

public class ArrayStack<T> implements Stack<T> {

    private Object[] elements;
    private int count;

    public ArrayStack(int n) {
        elements = new Object[n];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void push(T val) {
        if (val == null) {
            return;
        }

        if (count == elements.length) {
            resize();
        }

        elements[count++] = val;
    }

    @Override
    public T pop() {
        return count > 0 ? (T) elements[--count] : null;
    }

    private void resize() {
        Object[] old_arr = elements;
        Object[] new_arr = new Object[old_arr.length * 2];

        for (int i = 0; i < old_arr.length; i++) {
            new_arr[i] = old_arr[i];
        }

        elements = new_arr;
    }
}
