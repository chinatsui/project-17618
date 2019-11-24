package me.chinatsui.algorithm.exercise.graph;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WordLadderIITest {

    private WordLadderII wordLadderII = new WordLadderII();

    @Test
    public void test() {
        List<List<String>> res = wordLadderII.findLadders("red", "tax",
                Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"));
        Assert.assertEquals(3, res.size());
    }
}
