package utils;

import java.util.List;

public class Print {

    public static void printArray(int[] array) {
        for (int k : array) {
            System.out.print(k + ", ");
        }

    }

    public static <T> void printArrayList(List<T> arr) {
        for (T s : arr) {
            System.out.print(s + " ");
        }

    }
}
