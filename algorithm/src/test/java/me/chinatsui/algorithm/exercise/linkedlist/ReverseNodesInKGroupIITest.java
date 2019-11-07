package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class ReverseNodesInKGroupIITest {

    private ReverseNodesInKGroupII rllkgii = new ReverseNodesInKGroupII();

    @Test
    public void test() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllkgii.reverseFromEnd(head, 1);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ListNodes.serialize(actual));
    }

    @Test
    public void test_02() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllkgii.reverseFromEnd(head, 2);
        Assert.assertArrayEquals(new int[]{1, 3, 2, 5, 4}, ListNodes.serialize(actual));
    }

    @Test
    public void test_03() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllkgii.reverseFromEnd(head, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 5, 4, 3}, ListNodes.serialize(actual));
    }
}
