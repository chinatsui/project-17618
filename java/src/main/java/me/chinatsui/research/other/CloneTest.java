package me.chinatsui.research.other;

import java.util.HashSet;

public class CloneTest {

    public static void main(String[] args) {
        HashSet s = new HashSet<>();
        Object obj1 = new Object();
        System.out.println(obj1);
        Object obj2 = new Object();
        System.out.println(obj2);
        Object obj3 = new Object();
        System.out.println(obj3);

        s.add(obj1);
        s.add(obj2);
        s.add(obj3);

        HashSet s1 = (HashSet)s.clone();
        for (Object i : s1) {
            System.out.println(i);
        }

        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());

    }

}
