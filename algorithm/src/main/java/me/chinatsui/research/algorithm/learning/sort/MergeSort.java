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
    }

}
