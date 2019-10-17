package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInSortedArrayIIITest {

    private SearchInSortedArrayIII sisaiii = new SearchInSortedArrayIII();

    @Test
    public void test() {
        Assert.assertEquals(7, sisaiii.search(new int[]{1, 2, 3, 5, 7, 8, 8, 8, 12, 15}, 8));
        Assert.assertEquals(-1, sisaiii.search(new int[]{1, 2, 3, 5, 7, 8, 8, 8, 12, 15}, 9));
    }
}
