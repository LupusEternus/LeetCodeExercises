package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniquePaths_II_Memorization {

    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        Map<String, Integer> memo = new HashMap<>();

        return helper(n - 1, m - 1, mat, memo);
    }

    private static int helper(int n, int m, ArrayList<ArrayList<Integer>> mat, Map<String, Integer> memo) {
        String key = n + ":" + m;
        if (memo.containsKey(key)) return memo.get(key);

        if (n == 0 && m == 0) {
            return 1;
        }
        if (mat.get(n).get(m) == -1) {
            return 0;

        }
        int up = 0;
        int left = 0;
        if (n > 0) up = helper(n - 1, m, mat, memo);
        if (m > 0) left = helper(n, m - 1, mat, memo);

        memo.putIfAbsent(key, up + left);

        return up + left;
    }

}
