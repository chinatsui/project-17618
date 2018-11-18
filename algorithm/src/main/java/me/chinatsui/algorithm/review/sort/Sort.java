package me.chinatsui.algorithm.review.sort;

import me.chinatsui.algorithm.util.DataUtils;

public abstract class Sort {

    abstract void sort(Comparable[] a);

    public boolean less(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) < 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i]))
                return false;
        }
        return true;
    }

    public void test(int size) {
        Integer[] a = DataUtils.getRandomIntegerArray(size, size);
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        validate(a);
        System.out.println(this.getClass().getSimpleName() + " sort " + size + " elements, cost " + (end - start) + " ms.");
    }

    private void validate(Comparable[] a) {
        if (!isSorted(a)) {
            throw new RuntimeException("Array is not sorted.");
        }
    }

}
