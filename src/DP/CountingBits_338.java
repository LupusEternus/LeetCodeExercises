package DP;

import java.util.HashMap;
import java.util.Map;

import static utils.Print.printArray;

public class CountingBits_338 {

    public static int[] countBits(int n) {
        int[] bits = new int[n+1];
        bits[0] = 0;
        for(int i = n; i>0; i--){
            int counter =0;
            int current = i;
            while(current > 0){
                if(current % 2 == 1){
                    counter++;
                }
                current /= 2;
            }
            bits[i] = counter;
        }
        return bits;
    }

    public static void main(String[] args) {

        int n = 5;
        printArray(countBits(n));

    }


}
