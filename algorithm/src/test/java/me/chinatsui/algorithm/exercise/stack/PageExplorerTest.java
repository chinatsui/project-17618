package me.chinatsui.algorithm.exercise.stack;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.exercise.stack.PageExplorer.Page;

public class PageExplorerTest {

    private PageExplorer pe = new PageExplorer();

    @Test
    public void test() {
        pe.navigate(new Page("A"));
        Assert.assertTrue(pe.backward());
        Assert.assertNull(null, pe.current());
        Assert.assertTrue(pe.forward());
        Assert.assertEquals("A", pe.current().name);
        Assert.assertFalse(pe.forward());
        pe.navigate(new Page("B"));
        pe.navigate(new Page("C"));
        pe.navigate(new Page("D"));
        Assert.assertEquals("D", pe.current().name);
        Assert.assertTrue(pe.backward());
        Assert.assertEquals("C", pe.current().name);
        Assert.assertTrue(pe.backward());
        Assert.assertEquals("B", pe.current().name);
        Assert.assertTrue(pe.forward());
        Assert.assertEquals("C", pe.current().name);
        pe.navigate(new Page("Z"));
        Assert.assertFalse(pe.forward());
        Assert.assertEquals("Z", pe.current().name);
    }
}
