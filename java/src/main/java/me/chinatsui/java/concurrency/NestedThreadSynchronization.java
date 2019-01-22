package me.chinatsui.java.concurrency;

import java.util.ArrayList;

public class NestedThreadSynchronization {

    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        NestedThreadSynchronization instance = new NestedThreadSynchronization();
        new Thread(() -> instance.test(10)).start();
        new Thread(() -> instance.test(20)).start();
        Thread.sleep(2000);
        for (int n : instance.list) {
            System.out.println(n);
        }
    }

    public void test(int num) {
        synchronized (this) {
            list.add(1 + num);
            synchronized (this) {
                new Thread(() -> {
                    list.add(2 + num);
                    list.add(3 + num);
                    list.add(4 + num);
                    list.add(5 + num);
                }).start();
            }
        }
    }
}
