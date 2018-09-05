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

class MergeSort2 {

    public static void main(String[] args) {
        Integer[] input = DataUtils.getRandomIntegerArray(10);
        System.out.println("input: " + Arrays.toString(input));
        new MergeSort2().sort(input);
        System.out.println("output: " + Arrays.toString(input));
    }

    private Integer[] aux;

    public void sort(Integer[] data) {
        aux = new Integer[data.length];
        sort(data, 0, data.length - 1);
    }

    public void sort(Integer[] data, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            sort(data, l, m);
            sort(data, m + 1, h);
            merge(data, l, m, h);
        }
    }

    private void merge(Integer[] data, int l, int m, int h) {
        for (int i = l; i <= h; i++) {
            aux[i] = data[i];
        }

        int left = l;
        int right = m + 1;
        for (int i = l; i <= h; i++) {
            if (left > m) {
                data[i] = aux[right++];
            } else if (right > h) {
                data[i] = aux[left++];
            } else if (aux[left] < aux[right]) {
                data[i] = aux[left++];
            } else {
                data[i] = aux[right++];
            }
        }
    }

}

class MergeSort3 {

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

class MergeSort4 extends Sort {

    Comparable[] aux;

    public static void main(String[] args) {
        new MergeSort4().test(100);
    }

    @Override
    void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];

        for (int i = 1; i < n; i *= 2) {
            for (int lo = 0; lo + i - 1 < n; lo += 2 * i) {
                int mid = lo + i - 1;
                int hi = mid + i;
                if (hi > n - 1) {
                    hi = n - 1;
                }
                merge(a, lo, mid, hi);
            }
        }
    }

    private void merge(Comparable[] nums, int lo, int mi, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }

        int left = lo;
        int right = mi + 1;
        for (int i = lo; i <= hi; i++) {
            if (left > mi) {
                nums[i] = aux[right++];
            } else if (right > hi) {
                nums[i] = aux[left++];
            } else if (less(aux[left], aux[right])) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }

}
