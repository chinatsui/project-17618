package me.chinatsui.research.algorithm.learning.queue;

public interface Queue<T> {

    void offer(T item);

    T poll();

    int size();

    boolean isEmpty();

}
