package me.chinatsui.research.algorithm.learning.sort;

import java.util.Arrays;

public class MergeSort3 {

    private int[] aux;

    public static void main(String[] args) {
        int[] a = {2, 5, 1, 45, 23, 33, 21, 13, 14, 5, 19, 222};
        new MergeSort3().sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] nums) {
        int n = nums.length;
        aux = new int[n];

        for (int i = 1; i < n; i *= 2) {
            for (int lo = 0; lo + i - 1 < n; lo += 2 * i) {
                int mid = lo + i - 1;
                int hi = mid + i;
                if (hi > n - 1) {
                    hi = n - 1;
                }
                merge(nums, lo, mid, hi);
            }
        }
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }

        int left = lo;
        int right = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (left > mid) {
                nums[i] = aux[right++];
            } else if (right > hi) {
                nums[i] = aux[left++];
            } else if (aux[left] < aux[right]) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }

}
