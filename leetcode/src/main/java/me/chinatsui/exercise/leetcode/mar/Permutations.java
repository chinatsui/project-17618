package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        ArrayList<Integer> list = (ArrayList)Arrays.stream(a).boxed().collect(Collectors.toList());
        ArrayList<Integer> list2 = (ArrayList) list.clone();
        System.out.println(list2);
    }

}
