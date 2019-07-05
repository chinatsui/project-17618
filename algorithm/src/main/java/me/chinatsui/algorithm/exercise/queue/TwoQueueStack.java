package me.chinatsui.algorithm.exercise.queue;

import java.util.LinkedList;

public class TwoQueueStack<T> {

    LinkedList<T> q1 = new LinkedList<>();
    LinkedList<T> q2 = new LinkedList<>();

    public void push(T t) {
        if (q1.isEmpty()) {
            q2.offer(t);
        } else if (q2.isEmpty()) {
            q1.offer(t);
        }
    }

    public T pop() {
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
    }
}
