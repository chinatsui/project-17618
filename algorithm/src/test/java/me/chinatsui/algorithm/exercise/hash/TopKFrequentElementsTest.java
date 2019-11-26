package me.chinatsui.algorithm.exercise.hash;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TopKFrequentElementsTest {

    private TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4};
        List<Integer> res = topKFrequentElements.resolve(nums, 2);
        Assert.assertEquals(2, res.size());
        Assert.assertEquals(3, (int)res.get(0));
        Assert.assertEquals(1, (int)res.get(1));
    }
}
