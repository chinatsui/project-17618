package me.chinatsui.research.algorithm.exercise.hihocoder.year_2017;

import java.util.Scanner;

/**
 * 字符消除问题
 */
public class Main1039 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            String[] strs = new String[count];

            for (int i = 0; i < count; i++) {
                strs[i] = in.next();
            }

            for (int i = 0; i < count; i++) {
                Result purgeResult = purge(strs[i], 0);
                System.out.println(bruteForce(purgeResult));
            }
        }
    }

    private static Result purge(String pStr, int pScore) {
        int start = -1;
        int end = -1;
        String str = pStr;
        int score = pScore;

        for (int i = 0; i < pStr.length() - 1; i++) {
            char m = pStr.charAt(i);
            char n = pStr.charAt(i + 1);

            if (m == n) {
                if (start == -1) {
                    start = i;
                    end = i + 1;
                } else {
                    end++;
                }
            } else {
                if (start > -1 && end > -1) {
                    break;
                }
            }
        }

        if (start > -1 && end > -1) {
            str = str.substring(0, start) + str.substring(end + 1);
            score = score + (end - start + 1);
            return purge(str, score);
        } else {
            return new Result(str, score);
        }
    }

    private static int bruteForce(Result pResult) {
        if (pResult.getStr().length() == 0) {
            return pResult.getScore() + 1;
        }

        int maxScore = -1;

        String[] inserts = {"A", "B", "C"};

        for (int i = 0; i < inserts.length; i++) {
            String insert = inserts[i];

            String pStr = pResult.getStr();
            int pScore = pResult.getScore();

            int temp = purge(insert + pStr, pScore).getScore();
            maxScore = maxScore < temp ? temp : maxScore;

            for (int j = 1; j < pStr.length(); j++) {
                temp = purge(pStr.substring(0, j) + insert + pStr.substring(j), pScore).getScore();
                maxScore = maxScore < temp ? temp : maxScore;
            }

            temp = purge(pStr + insert, pScore).getScore();
            maxScore = maxScore < temp ? temp : maxScore;
        }

        return maxScore;
    }

    public static class Result {

        String str;
        int score;

        public Result(String str, int score) {
            this.str = str;
            this.score = score;
        }

        public String getStr() {
            return str;
        }

        public int getScore() {
            return score;
        }

    }

}
