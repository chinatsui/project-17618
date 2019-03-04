package me.chinatsui.java.concurrent.interrupt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * LogService is made up of a message producer and consumer. The producers are those threads that
 * call LogService#log() method which pushes message into a blocking queue; The consumer is the LoggerThread
 * which always take the message from blocking queue and output it to console.
 * <p>
 * When try to stop the LogService, we should guarantee no producers keep being in a blocking state, and
 * consumer (a.k.a LoggerThread) is interrupted. Also, after stop() is called, those messages stashed in
 * blocking queue must be consumed eventually.
 */
public class LogService {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    private boolean isShutdown;
    private int reservation;
    private final LoggerThread loggerThread = new LoggerThread();

    void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                return;
            }
            reservation++;
        }
        queue.put(msg);
    }

    void start() {
        loggerThread.start();
    }

    synchronized void stop() {
        isShutdown = true;
        loggerThread.interrupt();
    }

    void await(long timeout) throws InterruptedException {
        loggerThread.join(timeout);
    }

    BlockingQueue<String> queue() {
        return queue;
    }

    class LoggerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (LogService.this) {
                    if (isShutdown && reservation == 0) {
                        return;
                    }
                }

                try {
                    String msg = queue.take();
                    synchronized (LogService.this) {
                        reservation--;
                    }
//                    System.out.println("[INFO] " + msg);
                } catch (InterruptedException e) {
                    run();
                }
            }
        }
    }
}
