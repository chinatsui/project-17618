package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class SimplifyPathTest {

    private SimplifyPath sp = new SimplifyPath();

    @Test
    public void test() {
        Assert.assertEquals("/a/b/c", sp.canonicalPath("/a//b////c/d//././/.."));
        Assert.assertEquals("/c", sp.canonicalPath("/a/../../b/../c//.//"));
        Assert.assertEquals("/c", sp.canonicalPath("/a/./b/../../c/"));
        Assert.assertEquals("/home/foo", sp.canonicalPath("/home//foo/"));
        Assert.assertEquals("/", sp.canonicalPath("/../"));
        Assert.assertEquals("/home", sp.canonicalPath("/home/"));
    }
}
