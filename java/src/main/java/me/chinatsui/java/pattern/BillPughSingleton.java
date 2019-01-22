package me.chinatsui.java.pattern;

/*
 * Prior to Java 5, java memory model had a lot of issues and above approaches used to fail
 * in certain scenarios where too many threads try to getRandomString the instance of the Singleton class simultaneously.
 * So Bill Pugh came up with a different approach to create the Singleton class using a inner static helper class.
 * The Bill Pugh Singleton implementation goes like this;
 *
 * Notice the private inner static class that contains the instance of the pattern class.
 * When the pattern class is loaded, SingletonHelper class is not loaded into memory
 * and only when someone calls the getInstance method, this class gets loaded and creates the Singleton class instance.
 *
 * This is the most widely used approach for Singleton class as it doesn't require synchronization.
 * I am using this approach in many of my projects and it’s easy to understand and implement also.
 */
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
