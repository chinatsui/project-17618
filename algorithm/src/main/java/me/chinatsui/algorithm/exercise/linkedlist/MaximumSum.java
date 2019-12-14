package me.chinatsui.algorithm.exercise.linkedlist;

import me.chinatsui.algorithm.entity.ListNode;
import me.chinatsui.algorithm.util.ListNodes;

/**
 * Given a linked list, the task is to find the maximum sum obtained by adding any k consecutive nodes of linked list.
 * <p>
 * Examples:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL, K = 5
 * Output: 20
 * Maximum sum is obtained by adding last 5 nodes
 * <p>
 * Input: 2 -> 5 -> 3 -> 6 -> 4 -> 1 -> 7 -> NULL, K = 4
 * Output: 18
 */
public class MaximumSum {

    public int maxSum(ListNode head, int k) {
        int sum = 0, curSum = sum, visited = 0;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (head != null) {
            if (visited < k) {
                sum += head.val;
                curSum += head.val;
            } else {
                prev = prev.next;
                curSum = curSum - prev.val + head.val;
                sum = Math.max(sum, curSum);
            }
            visited++;
            head = head.next;
        }

        return sum;
    }
}
