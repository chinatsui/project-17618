package me.chinatsui.research.algorithm.learning.queue;

public interface Queue<T> {

    void enqueue(T item);

    T dequeue();

    int size();

    boolean isEmpty();

}
