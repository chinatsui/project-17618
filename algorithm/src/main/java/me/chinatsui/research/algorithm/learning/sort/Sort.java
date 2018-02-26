package me.chinatsui.research.algorithm.learning.sort;

import me.chinatsui.research.algorithm.utils.DataUtils;

public abstract class Sort {

    abstract void sort(Comparable[] a);

    public boolean less(Comparable obj1, Comparable obj2) {
        return obj1.compareTo(obj2) < 0;
    }

    public void exchange(Comparable[] a, int i, int j) {
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
        validation(a);
        System.out.println(this.getClass().getSimpleName() + " sort " + size + " elements, cost " + (end - start) + " ms.");
    }

    private void validation(Comparable[] a) {
        if (!isSorted(a)) {
            throw new RuntimeException("Array is not sorted.");
        }
    }

}
