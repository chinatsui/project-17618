package me.chinatsui.research.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomString {

    public static String get(int size) {
        StringBuilder str = new StringBuilder();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            boolean isLowerCase = random.nextInt(2) % 2 == 0;
            int offset = random.nextInt(26);
            if (isLowerCase) {
                str.append((char)('a' + offset));
            } else {
                str.append((char)('A' + offset));
            }
        }
        return str.toString();
    }

}
