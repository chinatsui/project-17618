package me.chinatsui.algorithm.exercise.matrix;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {

    private WordSearch ws = new WordSearch();

    @Test
    public void test() {
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        Assert.assertTrue(ws.exist(board, "ABCCED"));
        Assert.assertTrue(ws.exist(board, "SEE"));
        Assert.assertFalse(ws.exist(board, "ABCB"));
    }
}
