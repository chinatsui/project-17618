package me.chinatsui.algorithm.exercise.string;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StringSplitTest {

    private StringSplit ss = new StringSplit();
    private static final int splitLength = 8;
    private static final String compliment = "0";

    @Test
    public void test_split_when_given_string_length_lt_sl_returns_one_split() {
        List<String> actual = ss.split("ABCDEF", splitLength, compliment);
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals("ABCDEF00", actual.get(0));
    }

    @Test
    public void test_split_when_given_string_length_eq_sl_returns_one_split() {
        List<String> actual = ss.split("ABCDEFGH", splitLength, compliment);
        Assert.assertEquals(1, actual.size());
        Assert.assertEquals("ABCDEFGH", actual.get(0));
    }

    @Test
    public void test_split_when_given_string_length_gt_sl_returns_multiple_split() {
        String str = "ABCDEFG1asdfasdfqwer123123asdf";
        List<String> actual = ss.split(str, splitLength, compliment);
        Assert.assertEquals(4, actual.size());
        Assert.assertEquals("ABCDEFG1", actual.get(0));
        Assert.assertEquals("asdfasdf", actual.get(1));
        Assert.assertEquals("qwer1231", actual.get(2));
        Assert.assertEquals("23asdf00", actual.get(3));
    }
}
