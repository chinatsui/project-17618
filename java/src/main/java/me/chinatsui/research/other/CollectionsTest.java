package me.chinatsui.research.other;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class CollectionsTest {

    @Test
    public void test_binary_search() {
        ArrayList<Integer> list = new ArrayList();
        System.out.println(Collections.binarySearch(list, 5));
        list.add(1);
        list.add(2);

        list.add(0, 3);
        
    }

}
