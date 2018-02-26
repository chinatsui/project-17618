package me.chinatsui.research.algorithm.learning.stack;

public interface Stack<T> {

    T peek();

    T pop();

    void push(T item);

    int size();

    boolean isEmpty();

}
