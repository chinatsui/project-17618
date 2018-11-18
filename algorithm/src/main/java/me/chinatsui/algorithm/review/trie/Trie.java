package me.chinatsui.algorithm.review.trie;

/// all characters are lower-case
public class Trie {

    private TreeNode root = new TreeNode('^');

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] ch = word.toCharArray();

        TreeNode cur = root;
        for (char c : ch) {
            int pos = c - 'a';
            if (cur.des[pos] == null) {
                cur.des[pos] = new TreeNode(c);
            }
            cur = cur.des[pos];
        }
        cur.des[26] = new TreeNode('$');
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        char[] ch = word.toCharArray();
        TreeNode cur = root;

        for (char c : ch) {
            int pos = c - 'a';
            if (cur.des[pos] == null) {
                return false;
            }
            cur = cur.des[pos];
        }

        return cur.des[26] != null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        char[] ch = prefix.toCharArray();
        TreeNode cur = root;

        for (char c : ch) {
            int pos = c - 'a';
            if (cur.des[pos] == null) {
                return false;
            }
            cur = cur.des[pos];
        }

        return true;
    }

    static class TreeNode {

        char val;
        TreeNode[] des = new TreeNode[27];

        TreeNode(char val) {
            this.val = val;
        }

    }

}

