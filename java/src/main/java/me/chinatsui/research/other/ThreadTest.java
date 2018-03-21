package me.chinatsui.research.other;

/**
 * Created by chinatsui on 23/02/2018.
 */
public class ThreadTest {

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ".....1.....");
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        System.out.println(Thread.currentThread().getName() + "Outer finished.");
    }

}
