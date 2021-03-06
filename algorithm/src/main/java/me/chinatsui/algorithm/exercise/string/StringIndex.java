package me.chinatsui.algorithm.exercise.string;

public class StringIndex {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] hayCh = haystack.toCharArray();
        char[] neeCh = needle.toCharArray();

        for (int i = 0; i < hayCh.length; i++) {
            if (hayCh[i] == neeCh[0]) {
                boolean found = true;
                for (int j = 1; j < neeCh.length; j++) {
                    if (i + j == hayCh.length) {
                        return -1;
                    }
                    if (hayCh[i + j] != neeCh[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }
}
