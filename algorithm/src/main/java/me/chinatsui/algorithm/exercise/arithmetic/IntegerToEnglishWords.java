package me.chinatsui.algorithm.exercise.arithmetic;

public class IntegerToEnglishWords {

    private final String[] LESS_THAN_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String res = "";
        int scale = 0;
        while (num > 0) {
            if (num % 1000 != 0) { // handle the numbers are not like 1,000,000
                res = convert(num % 1000) + " " + THOUSANDS[scale] + " " + res;
            }
            num /= 1000;
            scale++;
        }

        return res.trim();
    }

    private String convert(int num) {
        String res;
        if (num == 0) {
            res = "";
        } else if (num < 20) {
            res = LESS_THAN_20[num];
        } else if (num < 100) {
            res = TENS[num / 10] + " " + convert(num % 10);
        } else {
            res = LESS_THAN_20[num / 100] + " Hundred " + convert(num % 100);
        }
        return res.trim();
    }
}
