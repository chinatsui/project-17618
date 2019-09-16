package me.chinatsui.algorithm.exercise.matrix;

import org.junit.Assert;
import org.junit.Test;

public class RotateImageTest {

    private RotateImage ri = new RotateImage();

    @Test
    public void test() {
        int[][] image = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        ri.rotate(image);
        Assert.assertArrayEquals(new int[]{7, 4, 1}, image[0]);
        Assert.assertArrayEquals(new int[]{8, 5, 2}, image[1]);
        Assert.assertArrayEquals(new int[]{9, 6, 3}, image[2]);
    }
}
