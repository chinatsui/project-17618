package me.chinatsui.java.pattern;

/*
 * Lazy initialization method to implement Singleton pattern creates the instance in the global access method.
 * Here is the sample code for creating Singleton class with this approach.
 *
 * The implementation works fine in case of single threaded environment but when it comes to multithreaded systems,
 * it can cause issues if multiple threads are inside the "if loop" at the same time.
 *
 * It will destroy the pattern pattern and both threads will getRandomString the different instances of pattern class.
 */
public class LazyInitialization {

    private static LazyInitialization instance;

    private LazyInitialization() {
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
