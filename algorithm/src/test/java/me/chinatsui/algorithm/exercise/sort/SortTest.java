package me.chinatsui.algorithm.exercise.sort;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.util.Nums;

public class SortTest {

    @Test
    public void test_merge_sort_works_as_expected() {
        int[] data = Nums.getRandomIntegerArray(15, 20);
        new MergeSort().sort(data);
        Assert.assertTrue(isArraySorted(data));
    }

    @Test
    public void test_quick_sort_works_as_expected() {
        int[] data = Nums.getRandomIntegerArray(15, 20);
        new QuickSort().sort(data);
        Assert.assertTrue(isArraySorted(data));
    }

    @Test
    public void test_heap_sort_works_as_expected() {
        int[] data = Nums.getRandomIntegerArray(15, 20);
        new HeapSort().sort(data);
        Assert.assertTrue(isArraySorted(data));
    }

    @Test
    public void test_bubble_sort_works_as_expected() {
        int[] data = Nums.getRandomIntegerArray(15, 20);
        new BubbleSort().sort(data);
        Assert.assertTrue(isArraySorted(data));
    }

    @Test
    public void test_insertion_sort_works_as_expected() {
        int[] data = Nums.getRandomIntegerArray(15, 20);
        new InsertionSort().sort(data);
        Assert.assertTrue(isArraySorted(data));
    }

    @Test
    public void test_selection_sort_works_as_expected() {
        int[] data = Nums.getRandomIntegerArray(15, 20);
        new SelectionSort().sort(data);
        Assert.assertTrue(isArraySorted(data));
    }

    private boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
