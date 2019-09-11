package me.chinatsui.algorithm.exercise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

public class ReverseNodesInKGroupTest {

    private ReverseNodesInKGroup rnikg = new ReverseNodesInKGroup();

    @Test
    public void test_01() {
        ListNode head = ListNodes.construct(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rnikg.reverse(head, 1);
        Assert.assertEquals(ListNodes.construct(new int[]{1, 2, 3, 4, 5}), actual);
    }

    @Test
    public void test_02() {
        ListNode head = ListNodes.construct(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rnikg.reverse(head, 2);
        Assert.assertEquals(ListNodes.construct(new int[]{2, 1, 4, 3, 5}), actual);
    }

    @Test
    public void test_03() {
        ListNode head = ListNodes.construct(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rnikg.reverse(head, 3);
        Assert.assertEquals(ListNodes.construct(new int[]{3, 2, 1, 4, 5}), actual);
    }
}
