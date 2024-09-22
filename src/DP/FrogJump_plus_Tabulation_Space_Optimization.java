package DP;

import java.util.ArrayList;
import java.util.List;

public class FrogJump_plus_Tabulation_Space_Optimization {

    public static int frogJump(int target, ArrayList<Integer> heights) {

        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < target; i++) {

            int fs = prev + Math.abs(heights.get(i) - heights.get(i - 1));
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights.get(i) - heights.get(i - 2));
            }
            int current = Math.min(fs, ss);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));
        int n = arr.size();

        System.out.println(frogJump(n, arr));

    }
}
