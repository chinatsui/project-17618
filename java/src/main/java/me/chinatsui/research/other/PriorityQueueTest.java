package me.chinatsui.research.other;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.offer(123);
        q.offer(321);
        q.offer(12);
        q.offer(34);
        while(q.size() > 0) {
            System.out.println(q.poll());
        }
    }

}
