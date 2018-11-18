package me.chinatsui.algorithm.exercise.queue_and_stack;

import java.util.LinkedList;

public class TwoQueueStack<T> {

    LinkedList<T> q1 = new LinkedList();
    LinkedList<T> q2 = new LinkedList();

    public static void main(String[] args) {
        TwoQueueStack s = new TwoQueueStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.pop());
    }

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
