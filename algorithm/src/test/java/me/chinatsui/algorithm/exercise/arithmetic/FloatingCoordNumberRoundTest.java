package me.chinatsui.algorithm.exercise.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class FloatingCoordNumberRoundTest {

    private FloatingPointNumberRound fpnr = new FloatingPointNumberRound();

    @Test
    public void test_round_up() {
        Assert.assertEquals(5, fpnr.round(4.567f));
    }

    @Test
    public void test_round_down() {
        Assert.assertEquals(4, fpnr.round(4.467f));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_round_on_negative_number() {
        fpnr.round(-123.63f);
        Assert.fail("UnsupportedOperationException should be thrown.");
    }
}
