package DP;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber_509 {
    public static Map<Integer, Integer> memory = new HashMap<>();

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        int result = fib(n - 1) + fib(n - 2);
        memory.put(n, result);
        return result;
    }
}