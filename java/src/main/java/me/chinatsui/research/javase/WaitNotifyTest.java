package me.chinatsui.research.javase;


public class WaitNotifyTest {

    public static void main(String[] args) {
        Printer printer = new Printer();

        new MyThread(printer).start();
        new MyThread(printer).start();

        try {
            Thread.sleep(2000);
            printer.releaseWaitSet(); // Current Main thread already gets the lock of printer, so it can notifyAll();
//            new Printer().releaseWaitSet(); this line won't notify above two thread as it owns different instance lock.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyThread extends Thread {

        private Printer printer;

        public MyThread(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            printer.print();
        }
    }

    public static class Printer {

        /*
         * The wait(), notify() and notifyAll() must be invoked in a thread which owns the lock, such as
         * synchronized method, synchronized code block or other method is invoked in a synchronized context.
         * Otherwise, the IllegalMonitorStateException is thrown.
         */

        public synchronized void print() {
            try {
                System.out.println(Thread.currentThread() + ": Wait on " + this);
                wait();
                System.out.println(Thread.currentThread() + ": Proceed on " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void releaseWaitSet() {
            System.out.println(Thread.currentThread() + " releases wait set on " + this);
            notifyAll();
        }

    }

}
