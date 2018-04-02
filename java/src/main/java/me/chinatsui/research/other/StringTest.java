package me.chinatsui.research.other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringTest {

    @Test
    public void test_double_quotes_equals_each_other() {
        String s1 = "ABC";
        String s2 = "ABC";
        Assert.assertTrue(s1 == s2);
    }

    @Test
    public void test_double_quotes_not_equal_to_new() {
        Assert.assertFalse("ABC" == new String("ABC"));
    }

    @Test
    public void test_hash_code_equal_does_not_mean_same() {
        String another = new String("ABC");
        Assert.assertTrue("ABC".hashCode() == another.hashCode());
        Assert.assertFalse("ABC" == another);
    }

}
