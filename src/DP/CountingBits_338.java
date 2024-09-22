package DP;


public class CountingBits_338 {

    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = n; i > 0; i--) {
            int counter = 0;
            int current = i;
            while (current > 0) {
                if (current % 2 == 1) {
                    counter++;
                }
                current /= 2;
            }
            bits[i] = counter;
        }
        return bits;
    }

}
