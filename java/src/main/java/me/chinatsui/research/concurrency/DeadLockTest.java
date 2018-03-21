package me.chinatsui.research.concurrency;


public class DeadLockTest {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(new Task1(o1, o2));
        Thread t2 = new Thread(new Task2(o1, o2));

        t1.start();
        t2.start();
    }

    static class Task1 implements Runnable {

        private Object o1;
        private Object o2;

        public Task1(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        public void run() {
            synchronized (o1) {
                try {
                    System.out.println(Thread.currentThread().getName() + " o1...");
                    Thread.sleep(2000);
                    synchronized (o2) {
                        System.out.println(Thread.currentThread().getName() + " o2...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Task2 implements Runnable {

        private Object o1;
        private Object o2;

        public Task2(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        public void run() {
            synchronized (o2) {
                try {
                    System.out.println(Thread.currentThread().getName() + " o2...");
                    Thread.sleep(2000);
                    synchronized (o1) {
                        System.out.println(Thread.currentThread().getName() + " o1...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
