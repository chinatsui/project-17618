package me.chinatsui.algorithm.exercise.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        if (text == null) {
            return;
        }

        TrieNode cur = root;
        for (int i = 0; i < text.length; i++) {
            if (cur.children.containsKey(text[i])) {
                cur = cur.children.get(text[i]);
            } else {
                TrieNode next = new TrieNode(text[i]);
                cur.children.put(text[i], next);
                cur = next;
            }
        }
        cur.isEnding = true;
    }

    public boolean exists(char[] prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length; i++) {
            if (cur.children.containsKey(prefix[i])) {
                cur = cur.children.get(prefix[i]);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean contains(char[] word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length; i++) {
            if (cur.children.containsKey(word[i])) {
                cur = cur.children.get(word[i]);
            } else {
                return false;
            }
        }

        return cur.isEnding;
    }

    static class TrieNode {
        char data;
        Map<Character, TrieNode> children;
        boolean isEnding;

        public TrieNode(char ch) {
            data = ch;
            children = new HashMap<>();
            isEnding = false;
        }
    }
}
