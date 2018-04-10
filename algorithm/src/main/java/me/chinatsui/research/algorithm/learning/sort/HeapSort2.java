package me.chinatsui.research.algorithm.learning.sort;

import java.util.Arrays;

import me.chinatsui.research.algorithm.utils.DataUtils;

public class HeapSort2 {

    public static void main(String[] args) {
        int[] x = Arrays.stream(DataUtils.getRandomIntegerArray(20)).mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(x));
        new HeapSort2().sort(x);
        System.out.println(Arrays.toString(x));
    }


    public void sort(int[] nums) {
        int n = nums.length;

        // construct max heap
        for (int i = n / 2; i >= 0; i--) {
            sink(nums, i, n - 1);
        }

        // sink sorting
        int last = n - 1;
        while (last >= 0) {
            exchange(nums, 0, last);
            last--;
            sink(nums, 0, last);
        }

    }

    private void sink(int[] nums, int i, int bound) {
        if (i > bound) {
            return;
        }

        int l = (i + 1) * 2 - 1;
        int r = (i + 1) * 2;

        if (r < bound) {
            // both left and right are valid
            int dst = nums[l] < nums[r] ? r : l;
            if (nums[i] < nums[dst]) {
                exchange(nums, i, dst);
                sink(nums, dst, bound);
            }
        } else if (l < bound) {
            // only left is valid
            if (nums[i] < nums[l]) {
                exchange(nums, i, l);
                sink(nums, l, bound);
            }
        }
    }

    private void exchange(int[] nums, int src, int dst) {
        int tmp = nums[dst];
        nums[dst] = nums[src];
        nums[src] = tmp;
    }

}
