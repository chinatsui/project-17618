package me.chinatsui.algorithm.exercise.arr;

import java.util.Arrays;

public enum MergeTwoSortedArray {

    INSTANCE;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 8, 9, 0, 0, 0, 0};
        int[] b = {4, 7};
        INSTANCE.merge(a, 7, b, 2);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0)
            A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];

        while (j >= 0)
            A[k--] = B[j--];
    }

}
