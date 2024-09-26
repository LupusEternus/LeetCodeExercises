package DP;

public class Triangle_Tabulation {

    public static int minimumPathSum(int[][] triangle, int n) {

        int[][] dp = new int[n][n];
        System.arraycopy(triangle[n - 1], 0, dp[n - 1], 0, triangle[n - 1].length);
        for(int i = n -2 ; i >= 0; i--){
            for (int j = 0 ; j < triangle[i].length;j++){
                int sum1 = triangle[i][j] + dp[i+1][j+1];
                int sum2 = triangle[i][j] + dp[i+1][j];
                dp[i][j] = Math.min(sum1,sum2);
            }
        }
      return dp[0][0];
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
