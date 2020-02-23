package me.chinatsui.java.concurrent.blocking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

    static class Foo {
        private int count = 1;
        private ReentrantLock lock;
        private Condition ready;

        public Foo() {
            lock = new ReentrantLock();
            ready = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lockInterruptibly();
            try {
                printFirst.run();
                count++;
                ready.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lockInterruptibly();
            try {
                while (count != 2) {
                    ready.await();
                }
                printSecond.run();
                count++;
                ready.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lockInterruptibly();
            try {
                while (count != 3) {
                    ready.await();
                }
                printThird.run();
            } finally {
                lock.unlock();
            }
        }
    }

    static class FooV2 {
        private int count = 1;

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            count++;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (count != 2) {
                wait();
            }
            printSecond.run();
            count++;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (count != 3) {
                wait();
            }
            printThird.run();
            count++;
            notifyAll();
        }
    }
}
