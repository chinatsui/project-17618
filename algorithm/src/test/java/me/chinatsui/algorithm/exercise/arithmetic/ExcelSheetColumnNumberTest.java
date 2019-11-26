package me.chinatsui.algorithm.exercise.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumnNumberTest {

    private ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();

    @Test
    public void test() {
        Assert.assertEquals(1, excelSheetColumnNumber.titleToNumber("A"));
        Assert.assertEquals(28, excelSheetColumnNumber.titleToNumber("AB"));
        Assert.assertEquals(701, excelSheetColumnNumber.titleToNumber("ZY"));
    }
}
