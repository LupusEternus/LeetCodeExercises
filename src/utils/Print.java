package utils;

import java.util.ArrayList;

public class Print {

    public static  void printArray(int[] array){
        for (int k : array) {
            System.out.print(k + ", ");
        }

    }

    public static <T> void printArrayList(ArrayList<T> arr){
        for(T s : arr){
            System.out.print(s + " ");
        }

    }
}
