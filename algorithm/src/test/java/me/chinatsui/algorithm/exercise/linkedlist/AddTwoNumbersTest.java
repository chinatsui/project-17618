package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {

    private AddTwoNumbers atn = new AddTwoNumbers();

    @Test
    public void test_01() {
        ListNode l1 = ListNodes.deserialize(new int[]{2, 4, 3});
        ListNode l2 = ListNodes.deserialize(new int[]{5, 6, 4});
        Assert.assertArrayEquals(new int[]{7, 0, 8}, ListNodes.serialize(atn.addTwoNumbers(l1, l2)));
    }

    @Test
    public void test_02() {
        ListNode l1 = ListNodes.deserialize(new int[]{5});
        ListNode l2 = ListNodes.deserialize(new int[]{5});
        Assert.assertArrayEquals(new int[]{0, 1}, ListNodes.serialize(atn.addTwoNumbers(l1, l2)));
    }

    @Test
    public void test_03() {
        ListNode l1 = ListNodes.deserialize(new int[]{1});
        ListNode l2 = ListNodes.deserialize(new int[]{9, 1});
        Assert.assertArrayEquals(new int[]{0, 2}, ListNodes.serialize(atn.addTwoNumbers(l1, l2)));
    }
}
