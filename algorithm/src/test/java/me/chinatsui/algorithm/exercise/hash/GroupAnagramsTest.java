package me.chinatsui.algorithm.exercise.hash;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    public void test() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams.groupAnagrams(strs);
        Assert.assertEquals(3, res.size());
    }
}
