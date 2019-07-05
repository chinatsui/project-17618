package me.chinatsui.algorithm.exercise.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    // [1, 2, 7, 7, 8]
    public static void main(String[] args) {
        int[] nums = {31, 41, 59, 26, 53, 58, 97};
        int[] result = Solution.INSTANCE.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public enum Solution {
        INSTANCE;

        public int[] maxSlidingWindow(int[] a, int k) {
            if (a == null || a.length == 0 || k <= 0) {
                return new int[0];
            }

            int n = a.length;
            int[] res = new int[n - k + 1];

            int ri = 0;

            // store index
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // remove numbers out of range k
                while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                    dq.pollFirst();
                }

                // remove smaller numbers in k range as they are useless
                while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
                    dq.pollLast();
                }

                // q contains index... r contains content
                dq.offerLast(i);
                if (i >= k - 1) {
                    res[ri++] = a[dq.peekFirst()];
                }
            }

            return res;
        }
    }
}