package me.chinatsui.algorithm.exercise.linkedlist;

import java.util.HashMap;

/**
 * LeetCode 146. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key startsWith in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    /**
     * Be aware of that Java built-in "LinkedHashMap" is also a LRU cache implementation.
     */

    private CacheNode head = new CacheNode();
    private CacheNode tail = new CacheNode();
    private HashMap<Integer, CacheNode> cache;
    private int capacity;
    private int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.val = val;
            elevate(node);
        } else {
            if (count == capacity) {
                CacheNode removed = removeLast();
                cache.remove(removed.key);
                count--;
            }
            CacheNode node = new CacheNode(key, val);
            cache.put(key, node);
            addFirst(node);
            count++;
        }
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            elevate(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void elevate(CacheNode node) {
        CacheNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private CacheNode removeLast() {
        CacheNode prev = tail.prev;
        CacheNode newPrev = prev.prev;
        newPrev.next = tail;
        tail.prev = newPrev;
        return prev;
    }

    private void addFirst(CacheNode node) {
        CacheNode next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class CacheNode {
        private int key;
        private int val;
        private CacheNode prev;
        private CacheNode next;

        public CacheNode() {
        }

        public CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
