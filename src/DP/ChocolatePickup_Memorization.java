package DP;

import java.util.HashMap;
import java.util.Map;

public class ChocolatePickup_Memorization {


    public static int maximumChocolates(int r, int c, int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();

        return f(0, 0, grid[0].length - 1, grid, memo);
    }

    private static int f(int x, int y1, int y2, int[][] grid, Map<String, Integer> mem) {
        String key = x + ":" + y1 + ":" + y2;

        if (mem.containsKey(key)) return mem.get(key);

        if (y1 < 0 || y2 < 0 || y1 >= grid[x].length || y2 >= grid[x].length) {
            return (int) (Math.pow(-10, 9));
        }
        if (x == grid.length - 1) {
            if (y1 == y2) {
                return grid[x][y1];
            } else
                return grid[x][y1] + grid[x][y2];
        }
        int currMax = Integer.MIN_VALUE;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int tempSum;
                if (y1 != y2) {
                    tempSum = grid[x][y1] + grid[x][y2] + f(x + 1, y1 + i, y2 + j, grid, mem);
                } else {
                    tempSum = grid[x][y1] + f(x + 1, y1 + i, y2 + j, grid, mem);
                }
                currMax = Math.max(currMax, tempSum);
            }
        }
        mem.putIfAbsent(key, currMax);
        return currMax;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        System.out.println(maximumChocolates(4, 3, grid));
    }
}

