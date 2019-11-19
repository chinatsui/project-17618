package me.chinatsui.algorithm.exercise.backtrack;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CombinationSumTest {

    private CombinationSum cs = new CombinationSum();

    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> actual = cs.combinationSum(candidates, target);
        Assert.assertEquals(3, actual.size());
        for (List<Integer> list : actual) {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            Assert.assertEquals(sum, 8);
        }
    }
}
