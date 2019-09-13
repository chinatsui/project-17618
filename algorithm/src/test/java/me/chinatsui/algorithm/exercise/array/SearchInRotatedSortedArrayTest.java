package me.chinatsui.algorithm.exercise.array;

import me.chinatsui.algorithm.exercise.binarysearch.SearchInRotatedSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();

    @Test
    public void test() {
        Assert.assertEquals(4, sirsa.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
