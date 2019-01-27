package me.chinatsui.java.concurrency;

import java.util.LinkedList;
import java.util.Queue;

import static me.chinatsui.java.commons.ThreadUtils.sleep;


public class ProducerConsumerModel {

    public static void main(String[] args) {
        LinkedList<String> q = new LinkedList<>();
        new Thread(new Producer(q)).start();
        new Thread(new Producer(q)).start();
        new Thread(new Producer(q)).start();
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
        new Thread(new Consumer(q)).start();
    }

    static class Producer implements Runnable {
        Queue<String> queue;

        public Producer(Queue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 10) {
                        System.out.println(threadName + ", wait.");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println(threadName + ", Start producing cakes...");
                        while (queue.size() < 10) {
                            System.out.println(threadName + ", producing one.");
                            sleep(100);
                            queue.offer("Cake.");
                        }
                        System.out.println(threadName + ", Stop producing...");
                        queue.notifyAll();
                    }
                }
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
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        System.out.println(threadName + ", wait.");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println(threadName + ", start consuming...");
                        while (queue.size() > 0) {
                            System.out.println(threadName + ", consuming one.");
                            sleep(100);
                            queue.poll();
                        }
                        System.out.println(threadName + ", stop consuming...");
                        queue.notifyAll();
                    }
                }
            }
        }
    }
}
