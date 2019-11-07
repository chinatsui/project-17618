package me.chinatsui.algorithm.exercise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

public class MergeKSortedListTest {

    private MergeKSortedList mksl = new MergeKSortedList();

    @Test
    public void test() {
        ListNode node1 = ListNodes.deserialize(new int[]{1, 4, 5});
        ListNode node2 = ListNodes.deserialize(new int[]{1, 3, 4});
        ListNode node3 = ListNodes.deserialize(new int[]{2, 6});
        ListNode[] nodes = new ListNode[]{node1, node2, node3};
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4, 5, 6}, ListNodes.serialize(mksl.merge(nodes)));
    }
}
