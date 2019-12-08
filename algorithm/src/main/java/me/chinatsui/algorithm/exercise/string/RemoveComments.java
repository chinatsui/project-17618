package me.chinatsui.algorithm.exercise.string;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        if (source == null || source.length == 0) {
            return new LinkedList<>();
        }

        int i = 0;
        List<String> result = new LinkedList<>();
        while (i < source.length) {
            String line = source[i];
            if (line.isEmpty()) {
                i++;
                continue;
            }
            int singleIndex = line.indexOf("//");
            int multipleIndex = line.indexOf("/*");
            if (singleIndex == -1 && multipleIndex == -1) {
                result.add(line);
                i++;
            }
            else {
                if (singleIndex != -1 && (multipleIndex == -1 || singleIndex < multipleIndex)) {
                    source[i] = line.substring(0, singleIndex);
                }
                else if (multipleIndex != -1 && (singleIndex == -1 || multipleIndex < singleIndex)) {
                    String firstPart = line.substring(0, line.indexOf("/*"));
                    source[i] = source[i].substring(source[i].indexOf("/*") + 2, source[i].length());
                    String secondPart = "";
                    while (i < source.length) {
                        if (source[i].indexOf("*/") != -1) {
                            secondPart = source[i].substring(source[i].indexOf("*/") + 2, source[i].length());
                            source[i] = firstPart + secondPart;
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return result;
    }
}
