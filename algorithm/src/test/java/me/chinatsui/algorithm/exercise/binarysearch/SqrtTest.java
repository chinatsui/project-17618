package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class SqrtTest {

    private Sqrt sqrt = new Sqrt();

    @Test
    public void test() {
        Assert.assertEquals(0.0d, sqrt.calculate(0.0d, 0.000001), 0);
        Assert.assertEquals(0.3d, sqrt.calculate(0.09d, 0.000001), 0);
        Assert.assertEquals(1.2d, sqrt.calculate(1.44d, 0.000001), 0);
        Assert.assertEquals(2.828427d, sqrt.calculate(8d, 0.000001), 0);
        Assert.assertEquals(3.0d, sqrt.calculate(9d, 0.000001), 0);
    }
}
