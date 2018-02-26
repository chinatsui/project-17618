package me.chinatsui.research.algorithm.learning.sort;


import me.chinatsui.research.algorithm.utils.DataUtils;

import java.util.Arrays;

public class QuickSort3 {

    public static void main(String[] args) {
        Integer[] input = DataUtils.getRandomIntegerArray(20);
        System.out.println(Arrays.toString(input));
        new QuickSort3().sort(input);
        System.out.println(Arrays.toString(input));
    }

    public void sort(Integer[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(Integer[] data, int l, int h) {
        if (l < h) {
            int key = l;
            for (int i = l + 1; i <= h; i++) {
                if (data[key] > data[i]) {
                    swap(data, key, i);
                    key++;
                }
            }

            sort(data, l, key - 1);
            sort(data, key + 1, h);
        }
    }

    private void swap(Integer[] data, int key, int target) {
        int tmp = data[target];
        for (int i = target; i > key; i--) {
            data[i] = data[i - 1];
        }
        data[key] = tmp;
    }

}
