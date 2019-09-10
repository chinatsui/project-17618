package me.chinatsui.algorithm.exercise.array;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumTest {

    private ThreeSum ts = new ThreeSum();

    @Test
    public void test_01() {
        List<List<Integer>> actual = ts.resolve(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.assertEquals(2, actual.size());
        for (List<Integer> nums : actual) {
            int sum = 0;
            for (Integer num : nums) {
                sum += num;
            }
            Assert.assertEquals(0, sum);
        }
    }

    @Test
    public void test_02() {
        List<List<Integer>> actual = ts.resolve(new int[]{0, 0, 0});
        Assert.assertEquals(1, actual.size());
        for (List<Integer> nums : actual) {
            int sum = 0;
            for (Integer num : nums) {
                sum += num;
            }
            Assert.assertEquals(0, sum);
        }
    }
}
