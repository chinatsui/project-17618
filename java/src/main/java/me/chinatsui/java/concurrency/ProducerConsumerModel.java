package me.chinatsui.java.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerModel {

    public static void main(String[] args) {
        LinkedList<String> q = new LinkedList<>();

        Producer p1 = new Producer(q);
        Producer p2 = new Producer(q);
        Producer p3 = new Producer(q);
        Producer p4 = new Producer(q);

        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }

    static class Producer implements Runnable {

        Queue<String> queue;

        public Producer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                while (true) {
                    synchronized (queue) {
                        if (queue.size() == 10) {
                            System.out.println(threadName + ", wait.");
                            queue.wait();
                        } else {
                            System.out.println(threadName + ", Start producing cakes...");
                            while (queue.size() < 10) {
                                System.out.println(threadName + ", producing one.");
                                Thread.sleep(100L);
                                queue.offer("Cake.");
                            }
                            System.out.println(threadName + ", Stop producing...");
                            queue.notifyAll();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class Consumer implements Runnable {

        Queue<String> queue;

        public Consumer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                while (true) {
                    synchronized (queue) {
                        if (queue.size() == 0) {
                            System.out.println(threadName + ", wait.");
                            queue.wait();
                        } else {
                            System.out.println(threadName + ", Start consuming...");
                            while (queue.size() > 0) {
                                System.out.println(threadName + ", consuming one.");
                                Thread.sleep(100L);
                                queue.poll();
                            }
                            System.out.println(threadName + ", Stop consuming...");
                            queue.notifyAll();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
