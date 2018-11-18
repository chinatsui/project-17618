package me.chinatsui.algorithm.review.queue;

public interface Queue<T> {

    void offer(T item);

    T poll();

    int size();

    boolean isEmpty();

}
