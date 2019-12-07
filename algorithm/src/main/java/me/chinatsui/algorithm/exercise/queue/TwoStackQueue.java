package me.chinatsui.algorithm.exercise.queue;

import java.util.LinkedList;

public class TwoStackQueue<T> {

    LinkedList<T> s1 = new LinkedList<>();
    LinkedList<T> s2 = new LinkedList<>();

    public void offer(T t) {
        s1.push(t);
    }

    public T poll() {
        if (s2.isEmpty()) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }

            if (s2.isEmpty()) {
                return null;
            } else {
                return s2.pop();
            }
        } else {
            return s2.pop();
        }
    }

}
