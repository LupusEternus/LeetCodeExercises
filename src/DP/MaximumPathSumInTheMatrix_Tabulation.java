package DP;

/*
Problem statement
You have been given an N*M matrix filled with integer numbers, find the maximum sum that
can be obtained from a path starting from any cell in the first row to any cell in the last
row.
From a cell in a row, you can move to another cell directly below that row, or diagonally
below left or right. So from a particular cell (row, col), we can move in three directions i.e.
Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)
 */

public class MaximumPathSumInTheMatrix_Tabulation {

    public static int getMaxPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);

        for (int i = 1; i < matrix.length; i++) {
            int d = Integer.MIN_VALUE;
            int dl = Integer.MIN_VALUE;
            int dr = Integer.MIN_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                d = matrix[i][j] + dp[i - 1][j];
                if (j > 0) {
                    dl = matrix[i][j] + dp[i - 1][j - 1];
                }
                if (j < matrix[i].length - 1) {
                    dr = matrix[i][j] + dp[i - 1][j + 1];
                }
                dp[i][j] = Math.max(d, Math.max(dl, dr));
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            result = Math.max(result, dp[dp.length - 1][i]);
        }
        return result;
    }
}
