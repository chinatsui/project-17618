package me.chinatsui.algorithm.exercise.partition;

public class FindNthSmallest {

    public int find(int[] arr, int n) {
        if (n > arr.length || n <= 0) throw new IllegalArgumentException();
        partition(arr, n - 1, 0, arr.length - 1);
        return arr[n - 1];
    }

    private void partition(int[] arr, int key, int l, int h) {
        if (l < h) {
            int pivot = h;
            int sm = l - 1;
            for (int i = l; i <= h - 1; i++) {
                if (arr[i] < arr[pivot]) {
                    sm++;
                    exchange(arr, sm, i);
                }
            }

            pivot = sm + 1;
            exchange(arr, pivot, h);

            if (pivot < key) {
                partition(arr, key, pivot + 1, h);
            } else {
                partition(arr, key, l, pivot - 1);
            }
        }
    }

    private void exchange(int[] arr, int m, int n) {
        if (m != n) {
            arr[m] = arr[m] ^ arr[n];
            arr[n] = arr[m] ^ arr[n];
            arr[m] = arr[m] ^ arr[n];
        }
    }
}
