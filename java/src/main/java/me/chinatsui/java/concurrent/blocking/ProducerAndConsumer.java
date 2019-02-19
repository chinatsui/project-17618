package me.chinatsui.java.concurrent.blocking;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import me.chinatsui.java.commons.RandomUtils;

/**
 * Created a simple array blocking queue to support producer and consumer model.
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        SimpleArrayBlockingQueue<String> queue = new SimpleArrayBlockingQueue<>(10);
        new Thread(new Producer(queue)).start();
//        new Thread(new Producer(queue)).start();
//        new Thread(new Producer(queue)).start();
//        new Thread(new Producer(queue)).start();
//        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    static class SimpleArrayBlockingQueue<E> {
        private ReentrantLock lock;
        private Condition notEmpty;
        private Condition notFull;
        private Object[] items;
        private int count;
        private int putIndex;
        private int takeIndex;

        SimpleArrayBlockingQueue(int capacity) {
            items = new Object[capacity];
            lock = new ReentrantLock(false);
            notEmpty = lock.newCondition();
            notFull = lock.newCondition();
        }

        void enqueue(E item) throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (count == items.length) {
                    notFull.await();
                }
                items[putIndex] = item;
                if (++putIndex == items.length) {
                    putIndex = 0;
                }
                count++;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        @SuppressWarnings("unchecked")
        E dequeue() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (count == 0) {
                    notEmpty.await();
                }
                E item = (E) items[takeIndex];
                if (++takeIndex == items.length) {
                    takeIndex = 0;
                }
                count--;
                notFull.signal();
                return item;
            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable {

        private SimpleArrayBlockingQueue<String> queue;

        Producer(SimpleArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String item = RandomUtils.getRandomString(10);
                    sleep(RandomUtils.getRandomInt(100, 200));
                    this.queue.enqueue(item);
                    System.out.println("Producer" + Thread.currentThread().getName() + ": produced one - " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private SimpleArrayBlockingQueue<String> queue;

        Consumer(SimpleArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String item = this.queue.dequeue();
                    sleep(RandomUtils.getRandomInt(400, 800));
                    System.out.println("Consumer" + Thread.currentThread().getName() + ": consumed one - " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
