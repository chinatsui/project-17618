package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class AddTwoNumbersTest {

    private AddTwoNumbers atn = new AddTwoNumbers();

    @Test
    public void test_01() {
        ListNode l1 = ListNodes.construct(new int[]{2, 4, 3});
        ListNode l2 = ListNodes.construct(new int[]{5, 6, 4});
        ListNode expected = ListNodes.construct(new int[]{7, 0, 8});
        Assert.assertEquals(expected, atn.addTwoNumbers(l1, l2));
    }

    @Test
    public void test_02() {
        ListNode l1 = ListNodes.construct(new int[]{5});
        ListNode l2 = ListNodes.construct(new int[]{5});
        ListNode expected = ListNodes.construct(new int[]{0, 1});
        Assert.assertEquals(expected, atn.addTwoNumbers(l1, l2));
    }

    @Test
    public void test_03() {
        ListNode l1 = ListNodes.construct(new int[]{1});
        ListNode l2 = ListNodes.construct(new int[]{9, 1});
        ListNode expected = ListNodes.construct(new int[]{0, 2});
        Assert.assertEquals(expected, atn.addTwoNumbers(l1, l2));
    }
}
