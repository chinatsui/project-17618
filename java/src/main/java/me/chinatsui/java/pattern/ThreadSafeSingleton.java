package me.chinatsui.java.pattern;

/*
 * An easier way to create a thread-safe pattern class is to make the global access method synchronized,
 * so that only one thread can execute this method at a time, but it reduces the performance because of cost
 * associated with the synchronized method, although we need it only for the first few threads who might create
 * the separate instances.
 *
 * To avoid this extra overhead every time, double checked locking principle is used.
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
