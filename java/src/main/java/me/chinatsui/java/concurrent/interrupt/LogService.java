package me.chinatsui.java.concurrent.interrupt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * LogService is made up of a msg producer and msg consumer. The msg producers are those threads that
 * call LogService#log() method which pushes msg into a blocking queue; The msg consumer is the LoggerThread
 * which always take the msg from blocking queue and output it to console.
 * <p>
 * When try to stop the LogService, we should guarantee no any msg producer keep being in a blocking state, and
 * msg consumer (a.k.a LoggerThread) is interrupted.
 */
public class LogService {

    private BlockingQueue<String> queue = new LinkedBlockingDeque<>();
    private boolean isShutdown;
    private int reservation;
    private final LoggerThread loggerThread = new LoggerThread();

    void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                throw new RuntimeException("LogService is shutdown.");
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


    class LoggerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (LogService.this) {
                    if (isShutdown && reservation == 0) {
                        break;
                    }
                }

                try {
                    String msg = queue.take();
                    synchronized (LogService.this) {
                        reservation--;
                    }
                    System.out.println("[INFO] " + msg);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
