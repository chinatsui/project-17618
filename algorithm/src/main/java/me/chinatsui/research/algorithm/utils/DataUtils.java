package me.chinatsui.research.algorithm.utils;

import java.util.Arrays;
import java.util.Random;

public class DataUtils {

    public static Integer[] getRandomIntegerArray(int size) {
        return getRandomIntegerArray(size, size);
    }

    public static Integer[] getRandomIntegerArray(int size, int scope) {
        Integer[] array = new Integer[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(scope);
        }

        return array;
    }

    public static Integer[] getSortedRandomIntegerArray(int size) {
        return getSortedRandomIntegerArray(size, size);
    }

    public static Integer[] getSortedRandomIntegerArray(int size, int scope) {
        Integer[] array = getRandomIntegerArray(size, scope);
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRandomIntegerArray(10)));
        System.out.println(Arrays.toString(getRandomIntegerArray(10, 100)));
        System.out.println(Arrays.toString(getSortedRandomIntegerArray(10)));
        System.out.println(Arrays.toString(getSortedRandomIntegerArray(10, 100)));
    }

}
