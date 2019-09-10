package me.chinatsui.algorithm.exercise.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class DecimalNumberRadixConverterTest {

    private DecimalNumberRadixConverter dnrc = new DecimalNumberRadixConverter();

    @Test(expected = UnsupportedOperationException.class)
    public void test_convert_when_given_negative_integer_throws_unsupported_exception() {
        dnrc.convert(-10, 8);
        Assert.fail("Unsupported operation exception should be thrown.");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_convert_when_given_base_is_greater_than_16_throws_unsupported_exception() {
        dnrc.convert(10, 17);
        Assert.fail("Unsupported operation exception should be thrown.");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_convert_when_given_base_is_less_than_1_throws_unsupported_exception() {
        dnrc.convert(10, -2);
        Assert.fail("Unsupported operation exception should be thrown.");
    }

    @Test
    public void test_convert_when_given_integer_less_than_base_return_expected_result() {
        Assert.assertEquals("4", dnrc.convert(4, 7));
        Assert.assertEquals("8", dnrc.convert(8, 10));
        Assert.assertEquals("E", dnrc.convert(14, 15));
        Assert.assertEquals("F", dnrc.convert(15, 16));
    }

    @Test
    public void test_convert_when_given_integer_equals_to_base_return_expected_result() {
        Assert.assertEquals("10", dnrc.convert(2, 2));
        Assert.assertEquals("10", dnrc.convert(4, 4));
        Assert.assertEquals("10", dnrc.convert(8, 8));
        Assert.assertEquals("10", dnrc.convert(13, 13));
        Assert.assertEquals("10", dnrc.convert(15, 15));
        Assert.assertEquals("10", dnrc.convert(16, 16));
    }

    @Test
    public void test_convert_when_given_integer_greater_than_base_return_expected_result() {
        Assert.assertEquals("111", dnrc.convert(7, 2));
        Assert.assertEquals("21", dnrc.convert(9, 4));
        Assert.assertEquals("12", dnrc.convert(12, 10));
        Assert.assertEquals("12", dnrc.convert(13, 11));
        Assert.assertEquals("2D", dnrc.convert(43, 15));
        Assert.assertEquals("3F", dnrc.convert(63, 16));
    }
}
