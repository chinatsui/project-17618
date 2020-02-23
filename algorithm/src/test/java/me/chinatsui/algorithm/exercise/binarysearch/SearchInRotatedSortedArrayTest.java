package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

    private SearchInRotatedArray sirsa = new SearchInRotatedArray();

    @Test
    public void test() {
        Assert.assertEquals(4, sirsa.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
