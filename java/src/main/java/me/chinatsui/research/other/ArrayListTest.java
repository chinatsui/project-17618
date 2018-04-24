package me.chinatsui.research.other;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArrayListTest {

    @Test
    public void testRetainAll() {
        ArrayList<Integer> list_1 = new ArrayList(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        ArrayList<Integer> list_2 = new ArrayList(Arrays.asList(1, 2, 3, 4, 50, 60, 70));
        list_1.retainAll(list_2);
        System.out.println(list_1);
        System.out.println(list_1.get(0));

    }

}
