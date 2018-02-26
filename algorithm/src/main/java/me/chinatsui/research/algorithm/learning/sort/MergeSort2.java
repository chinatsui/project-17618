package me.chinatsui.research.algorithm.learning.sort;


import me.chinatsui.research.algorithm.utils.DataUtils;

import java.util.Arrays;

public class MergeSort2 {

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
