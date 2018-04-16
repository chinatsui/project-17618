package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

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
