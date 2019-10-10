package me.chinatsui.algorithm.exercise.trie;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    private Trie trie = new Trie();

    @Test
    public void test() {
        trie.insert("abcdef".toCharArray());
        trie.insert("abcxxx".toCharArray());
        trie.insert("abcx".toCharArray());

        Assert.assertTrue(trie.exists("abc".toCharArray()));
        Assert.assertTrue(trie.exists("abcx".toCharArray()));
        Assert.assertFalse(trie.exists("abd".toCharArray()));
        Assert.assertTrue(trie.contains("abcx".toCharArray()));
        Assert.assertTrue(trie.contains("abcdef".toCharArray()));
        Assert.assertTrue(trie.contains("abcxxx".toCharArray()));
    }
}
