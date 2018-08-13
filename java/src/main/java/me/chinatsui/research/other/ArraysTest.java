package me.chinatsui.research.other;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {

    @Test
    public void test_asList_given_primitive_type_returns_one() {
        int[] nums = {1, 2, 3, 4, 5};
        Assert.assertEquals(1, Arrays.asList(nums).size());

        char[] ch = {'1', '2', '3', '4', '5'};
        Assert.assertEquals(1, Arrays.asList(ch).size());
    }

    @Test
    public void test_asList_given_reference_type_returns_exact_size() {
        Integer[] nums = {1, 2, 3, 4, 5};
        Assert.assertEquals(5, Arrays.asList(nums).size());

        Character[] ch = {'1', '2', '3', '4', '5'};
        Assert.assertEquals(5, Arrays.asList(ch).size());
    }

    @Test
    public void test_binary_search() {
        int[] nums = {10, 20, 30, 40, 50};
        int pos = Arrays.binarySearch(nums, 40);
        Assert.assertEquals(3, pos);
        pos = Arrays.binarySearch(nums, 36);  // - insertionPos - 1
        Assert.assertEquals(3, -pos - 1);
    }

    @Test
    public void test_array_copy() {
        int[] nums = {1, 2, 3, 4};
        int[] copy = new int[nums.length + 1];
        System.arraycopy(nums, 0, copy, 1, nums.length);
        System.out.println(Arrays.toString(copy));
    }

}
