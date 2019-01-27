package me.chinatsui.java.commons;

public class ThreadUtils {

    private ThreadUtils() {
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
