package me.chinatsui.algorithm.util;

import java.util.ArrayList;
import java.util.List;

import me.chinatsui.algorithm.entity.ListNode;

public class ListNodes {

    public static ListNode deserialize(int[] nums) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static int[] serialize(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int length(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }
}
