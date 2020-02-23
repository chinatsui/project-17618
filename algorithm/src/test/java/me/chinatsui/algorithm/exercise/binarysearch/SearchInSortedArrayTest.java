package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInSortedArrayTest {

    private SearchInRotatedArray sirsa = new SearchInRotatedArray();

    @Test
    public void test() {
        Assert.assertEquals(7, sirsa.search(new int[]{1, 3, 5, 6, 12, 13, 28, 33, 45, 67, 70, 89, 94}, 33));
        Assert.assertEquals(-1, sirsa.search(new int[]{1, 3, 5, 6, 12, 13, 28, 33, 45, 67, 70, 89, 94}, 34));
    }
}
