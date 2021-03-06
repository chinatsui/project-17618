package me.chinatsui.algorithm.exercise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

public class ReverseNodesInKGroupTest {

    private ReverseNodesInKGroup rllkg = new ReverseNodesInKGroup();

    @Test
    public void test_01() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllkg.reverse(head, 1);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ListNodes.serialize(actual));
    }

    @Test
    public void test_02() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllkg.reverse(head, 2);
        Assert.assertArrayEquals(new int[]{2, 1, 4, 3, 5}, ListNodes.serialize(actual));
    }

    @Test
    public void test_03() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllkg.reverse(head, 3);
        Assert.assertArrayEquals(new int[]{3, 2, 1, 4, 5}, ListNodes.serialize(actual));
    }
}
