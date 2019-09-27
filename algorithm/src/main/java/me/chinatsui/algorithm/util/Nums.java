package me.chinatsui.algorithm.util;

import java.util.Arrays;
import java.util.Random;

public class Nums {

    private Nums() {
    }

    public static int[] getRandomIntegerArray(int size) {
        return getRandomIntegerArray(size, size);
    }

    public static int[] getRandomIntegerArray(int size, int scope) {
        int[] array = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(scope);
        }

        return array;
    }

    public static int[] getSortedRandomIntegerArray(int size) {
        return getSortedRandomIntegerArray(size, size);
    }

    public static int[] getSortedRandomIntegerArray(int size, int scope) {
        int[] array = getRandomIntegerArray(size, scope);
        Arrays.sort(array);
        return array;
    }

    public static boolean isAscending(int[] nums) {
        if (nums == null) {
            return false;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
