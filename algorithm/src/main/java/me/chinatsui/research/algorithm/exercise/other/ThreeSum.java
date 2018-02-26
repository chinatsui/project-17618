package me.chinatsui.research.algorithm.exercise.other;

import me.chinatsui.research.algorithm.learning.search.BinarySearch;

import java.util.Arrays;

/**
 * Given an Integer array, find all triples of three integer which can sum to zeo.
 */
public class ThreeSum {

    /*
     * O(N*N*logN)
     */
    public static void seek(Integer[] data) {

        int count = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int part = data[i] + data[j];

                int index = BinarySearch.search(data, -part);
                if (index > j) {
                    count++;
                    System.out.println("[" + data[i] + "," + data[j] + "," + (-part) + "]");
                }
            }
        }

        System.out.println("Total: " + count);
    }

    public static void main(String[] args) {
        Integer[] data = {1, 4, -5, 2, 3, 6, 17, -21, -9};
        Arrays.sort(data);
        seek(data);
    }

}
