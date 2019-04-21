package me.chinatsui.algorithm.core.linear_list;

public interface Queue<T> {

    int size();

    boolean offer(T val);

    T poll();
}
