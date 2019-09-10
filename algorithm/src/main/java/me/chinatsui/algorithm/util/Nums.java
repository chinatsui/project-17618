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
}