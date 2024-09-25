package DP;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum_Memorization {

    public static int minSumPath(int[][] grid) {

        Map<String, Integer> memory = new HashMap<>();
        int n = grid.length - 1;
        int m = grid[0].length - 1;

        return f(grid, n, m, memory);
    }

    private static int f(int[][] grid, int x, int y, Map<String, Integer> mem) {
        String key = x + ":" + y;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (x > 0) {
            up = grid[x][y] + f(grid, x - 1, y, mem);
        }
        if (y > 0) {
            left = grid[x][y] + f(grid, x, y - 1, mem);
        }
        int result = Math.min(up, left);
        mem.putIfAbsent(key, result);

        return result;
    }


    public static void main(String[] args) {

        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println(minSumPath(grid));
    }
}
