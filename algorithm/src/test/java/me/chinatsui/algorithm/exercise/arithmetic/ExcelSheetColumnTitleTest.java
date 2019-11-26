package me.chinatsui.algorithm.exercise.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumnTitleTest {

    private ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

    @Test
    public void test() {
        Assert.assertEquals("A", excelSheetColumnTitle.convertToTitle(1));
        Assert.assertEquals("AB", excelSheetColumnTitle.convertToTitle(28));
        Assert.assertEquals("ZY", excelSheetColumnTitle.convertToTitle(701));
    }
}
