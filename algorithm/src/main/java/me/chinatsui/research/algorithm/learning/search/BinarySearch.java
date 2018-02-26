package me.chinatsui.research.algorithm.learning.search;

import me.chinatsui.research.algorithm.utils.DataUtils;

import java.util.Arrays;

public class BinarySearch {

    public static int search(Comparable[] data, int key) {
        validate(data);
        return search(data, 0, data.length - 1, key);
    }

    private static void validate(Comparable[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0) {
                throw new IllegalArgumentException("Input array is not sorted.");
            }
        }
    }

    private static int search(Comparable[] data, int lo, int hi, Comparable key) {
        if (lo >= hi) {
            return data[lo].compareTo(key) == 0 ? lo : -1;
        }

        int middle = (lo + hi) / 2;

        if (key.compareTo(data[middle]) == 0) {
            return middle;
        } else if (key.compareTo(data[middle]) < 0) {
            hi = middle - 1;
            return search(data, lo, hi, key);
        } else {
            lo = middle + 1;
            return search(data, lo, hi, key);
        }
    }

    public static void main(String[] args) {
        Integer[] data = DataUtils.getSortedRandomIntegerArray(20, 100);
        System.out.println(Arrays.toString(data));
        System.out.println(search(data, 0, data.length - 1, 3));
    }

}
