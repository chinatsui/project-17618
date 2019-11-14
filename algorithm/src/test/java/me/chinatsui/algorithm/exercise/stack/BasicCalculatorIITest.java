package me.chinatsui.algorithm.exercise.stack;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorIITest {

    private BasicCalculatorII bcii = new BasicCalculatorII();

    @Test
    public void test() {
        Assert.assertEquals(7, bcii.calculate("3+2*2"));
        Assert.assertEquals(1, bcii.calculate(" 3/2 "));
        Assert.assertEquals(5, bcii.calculate(" 3+5 / 2 "));
    }
}
