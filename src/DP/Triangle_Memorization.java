package DP;

import java.util.HashMap;
import java.util.Map;

public class Triangle_Memorization {

    public static int minimumPathSum(int[][] triangle, int n) {
        Map<String,Integer> memo = new HashMap<>();
        return f(triangle, 0, 0, n, memo);
    }

    private static int f(int[][] grid, int x, int y, int n, Map<String,Integer> memo) {

        String key = x + ":" + y;
        if(memo.containsKey(key)) return memo.get(key);

        if (x == n - 1) return grid[x][y];

        int down = Integer.MAX_VALUE;
        int downR = Integer.MAX_VALUE;

        if (x < grid.length) {
            down = grid[x][y] + f(grid, x + 1, y, n,memo);
            downR = grid[x][y] + f(grid, x + 1, y + 1, n,memo);
        }
        int result = Math.min(downR, down);
        memo.putIfAbsent(key,result);

        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        System.out.println(minimumPathSum(grid, 4));
    }
}
