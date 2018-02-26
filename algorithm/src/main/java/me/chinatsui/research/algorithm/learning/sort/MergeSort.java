package me.chinatsui.research.algorithm.learning.sort;

import me.chinatsui.research.algorithm.utils.DataUtils;

import java.util.Arrays;

// o(n*log(n))
public class MergeSort extends Sort {

    public static void main(String[] args) {
        Integer[] a = DataUtils.getRandomIntegerArray(20);
        System.out.println(Arrays.toString(a));
        System.out.println("----");
        new MergeSort().sort(a);
        System.out.println("----");
        System.out.println(Arrays.toString(a));
    }

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo, i = lo, j = mid + 1; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++]; // Left is over
            } else if (j > hi) {
                a[k] = aux[i++]; // Right is over
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
//        System.out.println(Arrays.toString(a));
    }


    /* -- Before  -- */
    /*
    @Override
    void sort(Comparable[] a) {
        System.arraycopy(mergeSort(a), 0, a, 0, a.length);
    }

    private Comparable[] mergeSort(Comparable[] a) {
        if (a.length == 1) {
            return a;
        }

        Comparable[] left = new Comparable[a.length / 2];
        Comparable[] right = new Comparable[a.length - a.length / 2];

        System.arraycopy(a, 0, left, 0, a.length / 2);
        System.arraycopy(a, a.length / 2, right, 0, a.length - a.length / 2);

        Comparable[] toBeMergedLeft = mergeSort(left);
        Comparable[] toBeMergedRight = mergeSort(right);

        return merge(toBeMergedLeft, toBeMergedRight);
    }

    private Comparable[] merge(Comparable[] a, Comparable[] b) {
        Comparable[] result = new Comparable[a.length + b.length];

        int m = 0;
        int n = 0;
        Comparable min;

        for (int i = 0; i < result.length; i++) {
            if (m == a.length) {
                min = b[n];
                n++;
            } else if (n == b.length) {
                min = a[m];
                m++;
            } else if (less(a[m], b[n])) {
                min = a[m];
                m++;
            } else {
                min = b[n];
                n++;
            }

            result[i] = min;
        }

        return result;
    }
    */

}
