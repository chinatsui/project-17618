package me.chinatsui.algorithm.exercise.string;

import java.util.ArrayList;
import java.util.List;

/*
 * Case 1: str = "ABCD", splitLength = 8, complement = "0", then returns {ABCD0000}.
 * Case 2: str = "ABCDEFGH", splitLength = 8, complement = "0", then returns {ABCDEFGH}.
 * Case 3: str = "ABCDEFGHabcde", splitLength = 8, complement = "0", then returns {ABCDEFGH, abcde000}.
 */
public class StringSplit {

    public List<String> split(String str, int splitLength, String complement) {
        if (str == null || str.length() < 1) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        while (true) {
            if (str.length() <= splitLength) {
                res.add(String.format("%-8s", str).replace(" ", complement));
                break;
            } else {
                res.add(str.substring(0, splitLength));
                str = str.substring(splitLength);
            }
        }

        return res;
    }
}
