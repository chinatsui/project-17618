package me.chinatsui.algorithm.core.sort;

import me.chinatsui.algorithm.util.DataUtils;
import org.junit.Before;
import org.junit.Test;

public class MergeSortSortTest extends AbstractSortTest {

    private MergeSort mergeSort;

    @Before
    public void setup() {
        mergeSort = new MergeSort();
    }

    @Test
    public void test_sort_with_iteration() {
        mergeSort.sortWithIteration(null);
        mergeSort.sortWithIteration(new int[0]);

        int[] arr = DataUtils.getRandomIntegerArray(30, 100);
        mergeSort.sortWithIteration(arr);
        verifySorted(arr);
    }

    @Test
    public void test_sort_with_recursion() {
        mergeSort.sortWithRecursion(null);
        mergeSort.sortWithRecursion(new int[0]);

        int[] arr = DataUtils.getRandomIntegerArray(30, 100);
        mergeSort.sortWithRecursion(arr);
        verifySorted(arr);
    }
}
