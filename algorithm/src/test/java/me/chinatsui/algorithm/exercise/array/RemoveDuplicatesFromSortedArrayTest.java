package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();

    @Test
    public void test() {
        Assert.assertEquals(5, rdfsa.remove(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        Assert.assertEquals(2, rdfsa.remove(new int[]{1, 1, 2}));
    }
}
