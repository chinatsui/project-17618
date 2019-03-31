package me.chinatsui.algorithm.core.sort;

import me.chinatsui.algorithm.util.DataUtils;
import org.junit.Before;
import org.junit.Test;

public class QuickSortSortTest extends AbstractSortTest {

    private QuickSort quickSort;

    @Before
    public void setup() {
        quickSort = new QuickSort();
    }

    @Test
    public void test_sort_with_iteration() {
        quickSort.sortWithIteration(null);
        quickSort.sortWithIteration(new int[0]);

        int[] arr = DataUtils.getRandomIntegerArray(30, 100);
        quickSort.sortWithIteration(arr);
        verifySorted(arr);
    }

    @Test
    public void test_sort_with_recursion() {
        quickSort.sortWithRecursion(null);
        quickSort.sortWithRecursion(new int[0]);

        int[] arr = DataUtils.getRandomIntegerArray(30, 100);
        quickSort.sortWithRecursion(arr);
        verifySorted(arr);
    }
}
