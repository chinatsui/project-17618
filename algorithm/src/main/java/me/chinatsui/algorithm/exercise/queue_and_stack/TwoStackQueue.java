package me.chinatsui.algorithm.exercise.queue_and_stack;

import java.util.LinkedList;

public class TwoStackQueue<T> {

    LinkedList<T> s1 = new LinkedList();
    LinkedList<T> s2 = new LinkedList();

    public static void main(String[] args) {
        TwoStackQueue q = new TwoStackQueue();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.poll());
        q.offer(4);
        System.out.println(q.poll());
        q.offer(5);
        System.out.println(q.poll());
        System.out.println(q.poll());
        q.offer(6);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

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
