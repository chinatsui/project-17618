package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInSortedArrayVTest {

    private SearchInSortedArrayV sisav = new SearchInSortedArrayV();

    @Test
    public void test() {
        Assert.assertEquals(4, sisav.search(new int[]{1, 2, 3, 5, 6, 8, 8, 8, 12, 15}, 7));
        Assert.assertEquals(7, sisav.search(new int[]{1, 2, 3, 5, 6, 8, 8, 8, 12, 15}, 9));
        Assert.assertEquals(-1, sisav.search(new int[]{1, 2, 3, 5, 6, 8, 8, 8, 12, 15}, 0));
    }
}
