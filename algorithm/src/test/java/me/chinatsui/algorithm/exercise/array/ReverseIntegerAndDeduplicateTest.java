package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class ReverseIntegerAndDeduplicateTest {

    private ReverseIntegerAndDeduplicate riad = new ReverseIntegerAndDeduplicate();

    @Test
    public void test_solution_works_as_expected() {
        Assert.assertEquals(1234567, riad.resolve(7654321));
        Assert.assertEquals(37689, riad.resolve(9876673));
        Assert.assertEquals(68, riad.resolve(888886666));
    }
}
