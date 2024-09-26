package DP;

/*
Problem statement
You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.
The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.
You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.

 */

public class Triangle {

    public static int minimumPathSum(int[][] triangle, int n) {

        return f(triangle, 0, 0, n);
    }

    private static int f(int[][] grid, int x, int y, int n) {

        if (x == n - 1) return grid[x][y];

        int down = Integer.MAX_VALUE;
        int downR = Integer.MAX_VALUE;

        if (x < grid.length) {
            down = grid[x][y] + f(grid, x + 1, y, n);
            downR = grid[x][y] + f(grid, x + 1, y + 1, n);
        }
        return Math.min(downR, down);
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
