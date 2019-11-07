package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTest {

    private ReverseLinkedList rll = new ReverseLinkedList();

    @Test
    public void test() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = rll.reverse(head);
        Assert.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, ListNodes.serialize(reversed));
    }
}
