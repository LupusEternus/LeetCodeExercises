package DP;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber_1137 {
    public static Map<Integer, Integer> mem = new HashMap<>();

    public static int tribonacci(int n) {
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        mem.put(n, result);

        return result;
    }
}
