package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListIITest {

    private ReverseLinkedListII rllii = new ReverseLinkedListII();

    @Test
    public void test() {
        ListNode head = ListNodes.deserialize(new int[]{1, 2, 3, 4, 5});
        ListNode actual = rllii.reverseBetween(head, 2, 4);
        Assert.assertArrayEquals(new int[]{1, 4, 3, 2, 5}, ListNodes.serialize(actual));
    }
}
