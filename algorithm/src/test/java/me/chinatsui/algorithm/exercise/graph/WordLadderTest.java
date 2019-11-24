package me.chinatsui.algorithm.exercise.graph;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class WordLadderTest {

    private WordLadder wordLadder = new WordLadder();

    @Test
    public void test() {
        int distance = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Assert.assertEquals(5, distance);
    }
}
