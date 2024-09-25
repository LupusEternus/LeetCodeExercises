package DP;

import java.util.ArrayList;

public class UniquePaths_II {

    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        int result = helper(n - 1, m - 1, mat);

        return result;
    }

    private static int helper(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        if (n == 0 && m == 0) {
            return 1;
        }
        if (mat.get(n).get(m) == -1) {
            return 0;

        }
        int up = 0;
        int left = 0;
        if (n > 0) up = helper(n - 1, m, mat);
        if (m > 0) left = helper(n, m - 1, mat);

        return up + left;
    }
}
