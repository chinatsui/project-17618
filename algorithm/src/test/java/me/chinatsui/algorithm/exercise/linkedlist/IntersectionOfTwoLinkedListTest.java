package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoLinkedListTest {

    private IntersectionOfTwoLinkedList iotll = new IntersectionOfTwoLinkedList();

    @Test
    public void test() {
        ListNode headA = ListNodes.deserialize(new int[]{4, 1});
        ListNode headB = ListNodes.deserialize(new int[]{5, 0, 1});
        ListNode headC = ListNodes.deserialize(new int[]{8, 4, 5});

        headA = headA.next;
        headA.next = headC;

        headB = headB.next.next;
        headB.next = headC;

        Assert.assertEquals(8, iotll.getIntersectionNode(headA, headB).val);
    }
}
