package me.chinatsui.algorithm.core.sort;

import org.junit.Before;
import org.junit.Test;

import me.chinatsui.algorithm.util.DataUtils;

public class HeapSortTest extends AbstractSortTest {

    private HeapSort heapSort;

    @Before
    public void setup() {
        heapSort = new HeapSort();
    }

    @Test
    public void test_sort() {
        int[] arr = DataUtils.getRandomIntegerArray(30, 100);
        heapSort.sort(arr);
        verifySorted(arr);
    }
}
