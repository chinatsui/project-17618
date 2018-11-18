package me.chinatsui.algorithm.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        String str = "";
        ListNode cur = this;
        while (cur != null) {
            str += cur.val + " -> ";
            cur = cur.next;
        }
        str += "null";
        return str;
    }
}
