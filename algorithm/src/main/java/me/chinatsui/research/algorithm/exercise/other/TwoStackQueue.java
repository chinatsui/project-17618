package me.chinatsui.research.algorithm.exercise.other;

import me.chinatsui.research.algorithm.learning.stack.ArrayStack;

public class TwoStackQueue<T> {

    ArrayStack<T> s1 = new ArrayStack<>();
    ArrayStack<T> s2 = new ArrayStack<>();

    int size = 0;

    public void enqueue(T item) {
        s1.push(item);
        size++;
    }

    public T dequeue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        T item = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        --size;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        TwoStackQueue tsq = new TwoStackQueue();
        tsq.enqueue("A");
        tsq.enqueue("B");
        tsq.enqueue("C");
        tsq.enqueue("D");

        System.out.println(tsq.dequeue());

        System.out.println(tsq.dequeue());
        tsq.enqueue("E");
        tsq.enqueue("F");

        while (!tsq.isEmpty()) {
            System.out.println(tsq.dequeue());
        }
    }

}
