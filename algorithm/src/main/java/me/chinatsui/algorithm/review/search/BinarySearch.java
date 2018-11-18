package me.chinatsui.algorithm.review.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] data = {11, 17, 19, 19, 25, 27, 27, 28, 36, 40, 40, 48, 48, 56, 58, 59, 63, 67, 67, 74};
        int key = 598;
        int index = search(data, key);
        if (index == -1) {
            System.out.println("Not found.");
        } else {
            System.out.println("key: " + key + ", Index: " + index + ", data[" + index + "]: " + data[index]);
        }
    }

    public static int search(int[] data, int key) {
        int l = 0;
        int h = data.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (key == data[m]) {
                return m;
            } else if (key < data[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return data[l] == key ? l : -1;
    }

}
