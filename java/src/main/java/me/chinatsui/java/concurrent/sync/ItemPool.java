package me.chinatsui.java.concurrent.sync;

import me.chinatsui.java.commons.RandomUtils;

import java.util.concurrent.Semaphore;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

public class ItemPool<E> {

    private Object[] items;
    private boolean[] used;
    private Semaphore available;

    public static void main(String[] args) {
        String[] items = new String[3];
        for (int i = 0; i < items.length; i++) {
            items[i] = RandomUtils.getRandomString(5);
        }
        ItemPool<String> pool = new ItemPool<>(items);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                String item = pool.get();
                System.out.println(threadName + " got one item: " + item);
                sleep(RandomUtils.getRandomInt(200, 800));
                System.out.println(threadName + " put back item: " + item);
                pool.putBack(item);
            }).start();
        }
    }

    private ItemPool(Object[] items) {
        if (items == null) {
            throw new NullPointerException();
        }
        this.items = items;
        used = new boolean[items.length];
        available = new Semaphore(items.length, true);
    }

    private E get() {
        try {
            available.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return getNextAvailable();
    }

    private void putBack(E item) {
        if (markAsUnused(item)) {
            available.release();
        }
    }

    @SuppressWarnings("unchecked")
    private synchronized E getNextAvailable() {
        for (int i = 0; i < items.length; i++) {
            if (!used[i]) {
                used[i] = true;
                return (E) items[i];
            }
        }
        return null;
    }

    private synchronized boolean markAsUnused(E item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                }
            }
        }
        return false;
    }
}
