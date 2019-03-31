package me.chinatsui.algorithm.core.sort;

import java.util.LinkedList;

public class QuickSort extends AbstractSort {

    public void sortWithIteration(int[] nums) {
        if (isEmpty(nums)) {
            return;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(nums.length - 1);
        while (!queue.isEmpty()) {
            int lo = queue.poll();
            int hi = queue.poll();

            if (lo >= hi) {
                continue;
            }

            int pivot = hi, sm = lo - 1;
            for (int i = lo; i < hi; i++) {
                if (nums[i] < nums[pivot]) {
                    swap(nums, ++sm, i);
                }
            }
            swap(nums, sm + 1, pivot);
            pivot = sm + 1;
            queue.offer(lo);
            queue.offer(pivot - 1);
            queue.offer(pivot + 1);
            queue.offer(hi);
        }
    }

    public void sortWithRecursion(int[] nums) {
        if (isEmpty(nums)) {
            return;
        }

        partition(nums, 0, nums.length - 1);
    }

    private void partition(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = hi, sm = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, ++sm, i);
            }
        }
        swap(nums, sm + 1, pivot);
        pivot = sm + 1;

        partition(nums, lo, pivot - 1);
        partition(nums, pivot + 1, hi);
    }
}
