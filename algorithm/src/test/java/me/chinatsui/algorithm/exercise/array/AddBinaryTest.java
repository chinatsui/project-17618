package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class AddBinaryTest {

    private AddBinary ab = new AddBinary();

    @Test
    public void test() {
        String a = "1010", b = "1011";
        Assert.assertEquals("10101", ab.addBinary(a, b));
    }
}
