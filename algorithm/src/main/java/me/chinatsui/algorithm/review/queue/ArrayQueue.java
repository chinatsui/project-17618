package me.chinatsui.algorithm.review.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> extends AbstractQueue<T> implements Iterable<T> {

    private Object[] elementData;
    private int size;

    public ArrayQueue() {
        elementData = new Object[10];
    }

    public void offer(T item) {
        if (size == elementData.length) {
            resize(elementData.length * 2);
        }

        elementData[size++] = item;
    }

    public T poll() {
        T item = (T) elementData[0];
        System.arraycopy(elementData, 1, elementData, 0, size - 1);
        elementData[--size] = null;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int cap) {
        elementData = Arrays.copyOf(elementData, cap);
    }

    private class Itr implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (T) elementData[cursor++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public static void main(String[] args) {
        ArrayQueue<String> q = new ArrayQueue();
        q.offer("A");
        q.offer("B");
        q.offer("C");
        q.offer("D");

        System.out.println(q);

        for (String item : q) {
            System.out.println(item);
        }
    }

}
