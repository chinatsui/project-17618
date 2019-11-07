package me.chinatsui.algorithm.exercise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

public class SwapNodesInPairsTest {

    private SwapNodesInPairs snip = new SwapNodesInPairs();

    @Test
    public void test_01() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4});
        ListNode actual = snip.swap(head);
        Assert.assertArrayEquals(new int[]{2, 1, 4, 3}, ListNodes.serialize(actual));
    }

    @Test
    public void test_02() {
        ListNode head = ListNodes.deserialize(new int[]{1});
        ListNode actual = snip.swap(head);
        Assert.assertArrayEquals(new int[]{1}, ListNodes.serialize(actual));
    }

    @Test
    public void test_03() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2});
        ListNode actual = snip.swap(head);
        Assert.assertArrayEquals(new int[]{2, 1}, ListNodes.serialize(actual));
    }
}
