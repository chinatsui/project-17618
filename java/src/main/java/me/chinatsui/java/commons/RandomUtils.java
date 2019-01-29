package me.chinatsui.java.commons;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private RandomUtils() {
    }

    public static String getRandomString(int size) {
        StringBuilder str = new StringBuilder();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            boolean isLowerCase = random.nextInt(2) % 2 == 0;
            int offset = random.nextInt(26);
            if (isLowerCase) {
                str.append((char) ('a' + offset));
            } else {
                str.append((char) ('A' + offset));
            }
        }
        return str.toString();
    }

    public static int getRandomInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }
}
