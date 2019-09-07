package me.chinatsui.algorithm.util;

import me.chinatsui.algorithm.entity.ListNode;

public class ListNodes {

    public static ListNode construct(int[] nums) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
}
