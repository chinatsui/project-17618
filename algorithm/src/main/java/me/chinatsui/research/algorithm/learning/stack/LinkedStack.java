package me.chinatsui.research.algorithm.learning.stack;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> extends AbstractStack<T> implements Iterable<T> {

    private Node<T> current;

    private int size = 0;

    public T peek() {
        if (current == null) {
            throw new NoSuchElementException("Stack underflow...");
        }
        return current.item;
    }

    public T pop() {
        size--;
        if (current == null) {
            throw new NoSuchElementException("Stack underflow...");
        }

        T result = current.item;
        current = current.next();

        return result;
    }

    public void push(T t) {
        size++;
        Node node = new Node(t, current);
        current = node;
    }

    public boolean isEmpty() {
        return current == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(current);
    }

    private class Itr implements Iterator<T> {

        private Node<T> node;

        public Itr(Node<T> first) {
            this.node = first;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                T item = node.item;
                node = node.next();
                return item;
            }
        }
    }

    private static class Node<T> {

        private T item;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.item = value;
            this.next = next;
        }

        public Node<T> next() {
            return next;
        }

    }

}
