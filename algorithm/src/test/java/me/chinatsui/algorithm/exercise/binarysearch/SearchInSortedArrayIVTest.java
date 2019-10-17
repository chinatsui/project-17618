package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInSortedArrayIVTest {

    private SearchInSortedArrayIV sisaiv = new SearchInSortedArrayIV();

    @Test
    public void test() {
        Assert.assertEquals(5, sisaiv.search(new int[]{1, 2, 3, 5, 6, 8, 8, 8, 12, 15}, 7));
        Assert.assertEquals(8, sisaiv.search(new int[]{1, 2, 3, 5, 6, 8, 8, 8, 12, 15}, 9));
        Assert.assertEquals(-1, sisaiv.search(new int[]{1, 2, 3, 5, 6, 8, 8, 8, 12, 15}, 20));
    }
}
