package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class ReverseIntegerAndDeduplicateTest {

    private ReverseIntegerAndDeduplicate piad = new ReverseIntegerAndDeduplicate();

    @Test
    public void test_solution_works_as_expected() {
        Assert.assertEquals(1234567, piad.resolve(7654321));
        Assert.assertEquals(37689, piad.resolve(9876673));
        Assert.assertEquals(68, piad.resolve(888886666));
    }
}
