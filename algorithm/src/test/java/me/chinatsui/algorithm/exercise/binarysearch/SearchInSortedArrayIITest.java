package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInSortedArrayIITest {

    private SearchInSortedArrayII sisaii = new SearchInSortedArrayII();

    @Test
    public void test() {
        Assert.assertEquals(5, sisaii.search(new int[]{1, 2, 3, 5, 7, 8, 8, 8, 12, 15}, 8));
        Assert.assertEquals(-1, sisaii.search(new int[]{1, 2, 3, 5, 7, 8, 8, 8, 12, 15}, 9));
    }
}
