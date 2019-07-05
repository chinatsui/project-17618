package me.chinatsui.algorithm.exercise.hash;

import java.util.HashMap;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String x = "1";
        x = x.replace("1", "");
        x = x.replace("0", "");
        System.out.println(x.length());
    }

    private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    static {
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);
    }

    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] ch = s.toCharArray();
        int n = ch.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int p = n - i - 1;
            res += map.get(ch[i]) * powerOf(p);
        }

        return res;
    }

    private int powerOf(int p) {
        int res = 1;
        for (int i = 1; i <= p; i++) {
            res *=26;
        }
        return res;
    }

}
