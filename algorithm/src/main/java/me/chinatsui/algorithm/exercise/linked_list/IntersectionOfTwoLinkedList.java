package me.chinatsui.algorithm.exercise.linked_list;

import me.chinatsui.algorithm.util.ListNode;

public enum IntersectionOfTwoLinkedList {

    INSTANCE;

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);

        ListNode headB = null;
        System.out.println(INSTANCE.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }

}