package me.chinatsui.research.other;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {

    @Test
    public void test_asList_given_primitive_type_return_one() {
        int[] nums = {1, 2, 3, 4, 5};
        Assert.assertEquals(1, Arrays.asList(nums).size());

        char[] ch = {'1', '2', '3', '4', '5'};
        Assert.assertEquals(1, Arrays.asList(ch).size());
    }

    @Test
    public void test_asList_given_reference_type_return_exact_size() {
        Integer[] nums = {1, 2, 3, 4, 5};
        Assert.assertEquals(5, Arrays.asList(nums).size());

        Character[] ch = {'1', '2', '3', '4', '5'};
        Assert.assertEquals(5, Arrays.asList(ch).size());
    }

}
