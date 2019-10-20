package me.chinatsui.algorithm.exercise.skiplist;

import me.chinatsui.algorithm.util.Nums;
import org.junit.Assert;
import org.junit.Test;
import me.chinatsui.algorithm.exercise.skiplist.SkipList.Node;

public class SkipListTest {

    @Test
    public void test() {
        SkipList skipList = populate();
        Node node = skipList.search(6);
        Assert.assertEquals(6, node.val);
        skipList.delete(6);
        node = skipList.search(6);
        Assert.assertNull(node);
    }

    private SkipList populate() {
        SkipList skipList = new SkipList();
        int[] nums = Nums.getRandomIntegerArray(40, 100);
        for (int num : nums) {
            skipList.insert(num);
        }
        skipList.insert(6);
        return skipList;
    }
}
