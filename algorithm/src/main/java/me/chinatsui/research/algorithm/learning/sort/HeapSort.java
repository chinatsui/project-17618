package me.chinatsui.research.algorithm.learning.sort;

import java.util.Arrays;

/**
 * Created by chinatsui on 14/01/2018.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] x = {1, 4, 2, 3, 4, 5, 6, 7, 8, 23, 23, 11, 22, 124, 32, 2346};
        System.out.println(x.length);
        new HeapSort().sort(x);
        System.out.println(Arrays.toString(x));
    }

    public void sort(int[] nums) {
        // parent -> left child: (i+1)*2 - 1
        // parent -> right child: (i+1)*2
        // child -> parent: (i-1) / 2

        int n = nums.length;

        // construct heap
        for (int i = n / 2; i >= 0; i--) {
            sink(nums, i, n - 1);
        }

        // sink sorting
        while (n > 0) {
            exchange(nums, 0, n - 1);
            n--;
            sink(nums, 0, n - 1);
        }

    }

    private void exchange(int[] nums, int src, int dst) {
        int temp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = temp;
    }

    private void sink(int[] nums, int i, int bound) {
        int leftChild = (i + 1) * 2 - 1;
        int rightChild = (i + 1) * 2;

        if (rightChild <= bound) {
            int prior = isPriorTo(nums, leftChild, rightChild) ? leftChild : rightChild;

            if (isPriorTo(nums, prior, i)) {
                exchange(nums, i, prior);
                sink(nums, prior, bound);
            }
        } else if (leftChild <= bound) {
            if (isPriorTo(nums, leftChild, i)) {
                exchange(nums, i, leftChild);
            }
        }
    }

    private boolean isPriorTo(int[] nums, int src, int dst) {
        return nums[src] > nums[dst];
    }

}
