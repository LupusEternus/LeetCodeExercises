package DP;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_70_RECandMemorization {

    public static Map<Integer, Integer> mem = new HashMap<>();

    public int climbStairs(int n) {

        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        mem.put(n, result);

        return result;
    }
}
