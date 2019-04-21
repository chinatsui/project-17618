package me.chinatsui.algorithm.core.linear_list;

public class LinkedNode<T> {

    T val;
    LinkedNode prev;
    LinkedNode next;

    public LinkedNode(T val) {
        this.val = val;
    }
}
