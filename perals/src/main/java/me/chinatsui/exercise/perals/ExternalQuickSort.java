package me.chinatsui.exercise.perals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ExternalQuickSort {

    public static void sort(File input, File output) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)))) {
            int[] a = new int[25000];
            for (int i = 0; i < 40; i++) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)))) {
                    int k = 0;

                    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                        Integer number = Integer.valueOf(line);
                        if (number >= 0 && number < 25000) {
                            a[k++] = number;
                        }
                    }

                    quickSort(a);
                    for (int j = 0; j < a.length; j++) {
                        writer.write(String.valueOf(a[i]));
                        writer.newLine();
                    }
                }
            }
        }
    }

    private static void quickSort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }

        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int l, int h) {
        if (l >= h) {
            return;
        } else {
            int m = l;

            for (int i = l + 1; i <= h; i++) {
                if (a[m] >= a[i]) {
                    int temp = a[i];
                    System.arraycopy(a, m, a, m + 1, i - m);
                    a[m] = temp;
                    m++;
                }
            }

            quickSort(a, l, m - 1);
            quickSort(a, m + 1, h);
        }
    }


    public static void main(String[] args) {
        int a[] = {3, 1, 23, 54, 34, 43, 45, 46, 57, 32, 134, 234, 345, 321, 222, 111, 10};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

}
