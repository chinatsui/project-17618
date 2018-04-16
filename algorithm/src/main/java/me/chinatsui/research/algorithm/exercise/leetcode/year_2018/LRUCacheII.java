package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.HashMap;

public class LRUCacheII {

    private Entry head, tail;
    private HashMap<Integer, Entry> map = new HashMap();
    private int size;
    private int capacity;

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        head = new Entry(-1, -1);
        tail = new Entry(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if (entry == null) {
            return -1;
        } else {
            updateLRU(entry);
            return entry.value;
        }
    }

    public void put(int key, int value) {
        Entry entry = map.get(key);
        if (entry == null) {
            size++;
            entry = new Entry(key, value);
            map.put(key, entry);
            addToHead(entry);
        } else {
            entry.value = value;
            updateLRU(entry);
        }

        if (size > capacity) {
            deleteTail();
        }
    }

    private void addToHead(Entry entry) {
        Entry hNext = head.next;
        head.next = entry;
        entry.prev = head;
        entry.next = hNext;
        hNext.prev = entry;
    }

    private void updateLRU(Entry entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
        addToHead(entry);
    }

    private void deleteTail() {
        Entry toBeDeleted = tail.prev;
        toBeDeleted.prev.next = tail;
        tail.prev = toBeDeleted.prev;
        map.remove(toBeDeleted.key);
        size--;
    }

    private class Entry {
        int key;
        int value;
        Entry prev, next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
