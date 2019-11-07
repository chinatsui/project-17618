package me.chinatsui.algorithm.exercise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

public class MergeTwoSortedListTest {

    private MergeTwoSortedList mtsl = new MergeTwoSortedList();

    @Test
    public void test() {
        ListNode h1 = ListNodes.deserialize(new int[]{1, 2, 4});
        ListNode h2 = ListNodes.deserialize(new int[]{1, 3, 4});
        ListNode actual = mtsl.merge(h1, h2);
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, ListNodes.serialize(actual));
    }
}
