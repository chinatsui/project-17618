package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int CAPACITY;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}
