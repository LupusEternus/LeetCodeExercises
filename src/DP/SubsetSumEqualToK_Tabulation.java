package DP;

public class SubsetSumEqualToK_Tabulation {

    public static boolean subsetSumToK(int n, int k, int[] arr) {

        boolean[][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (j >= arr[i]) {
                    pick = dp[i - 1][j - arr[i]];

                }
                dp[i][j] = notPick || pick;
            }
        }
        return dp[n - 1][k];
    }
}

