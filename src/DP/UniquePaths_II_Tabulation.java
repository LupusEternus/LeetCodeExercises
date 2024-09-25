package DP;

import java.util.ArrayList;

public class UniquePaths_II_Tabulation {

    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = 0;
                int left = 0;
                if (mat.get(i).get(j) == -1){
                    dp[i][j] = 0 ;
                }
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }

            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();


        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(0);
        row1.add(0);
        maze.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(-1);
        row2.add(0);
        maze.add(row2);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);
        maze.add(row3);

        System.out.println(mazeObstacles(3,3,maze));
    }
}
