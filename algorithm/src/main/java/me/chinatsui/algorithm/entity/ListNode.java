package me.chinatsui.algorithm.entity;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        return String.valueOf(val);
    }

    public String flatten() {
        String str = "";
        ListNode cur = this;
        while (cur != null) {
            str += cur.val + " -> ";
            cur = cur.next;
        }
        str += "null";
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
