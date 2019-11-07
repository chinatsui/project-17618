package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class RotateLinkedListTest {

    private RotateLinkedList rll = new RotateLinkedList();

    @Test
    public void test() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rll.rotateRight(head, 2);
        Assert.assertArrayEquals(new int[]{4, 5, 1, 2, 3}, ListNodes.serialize(actual));
    }
}
