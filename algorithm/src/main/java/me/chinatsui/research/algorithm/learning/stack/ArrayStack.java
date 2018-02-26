package me.chinatsui.research.algorithm.learning.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> extends AbstractStack<T> implements Iterable<T> {

    private Object[] elementData;
    private int size;

    public ArrayStack() {
        elementData = new Object[4];
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack underflow...");
        }
        return (T) elementData[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack underflow...");
        }
        T item = (T) elementData[--size];
        elementData[size] = null;

        if (size == elementData.length / 3) {
            resize(elementData.length / 2);
        }

        return item;
    }

    public void push(T element) {
        if (size == elementData.length) {
            resize(elementData.length * 2);
        }
        elementData[size++] = element;
    }

    private void resize(int cap) {
        elementData = Arrays.copyOf(elementData, cap);
    }

    public int capacity() {
        return elementData.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        int cursor;

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

}
