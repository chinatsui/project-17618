package me.chinatsui.research.algorithm.learning.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> extends AbstractQueue<T> implements Iterable<T> {

    Node<T> first;
    Node<T> last;

    private int size;

    public void offer(T item) {
        Node node = new Node(item, null);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = first.item;
        first = first.next;

        size--;

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(first);
    }

    private class Itr implements Iterator<T> {

        Node<T> node;

        public Itr(Node<T> first) {
            node = first;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = node.item;
            node = node.next;
            return item;
        }
    }

    private class Node<T> {

        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

    }

}
