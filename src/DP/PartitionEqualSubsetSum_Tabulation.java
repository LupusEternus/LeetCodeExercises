package DP;

public class PartitionEqualSubsetSum_Tabulation {

    public static boolean canPartition(int[] arr, int n) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int finalSum = sum / 2;

        boolean[][] dp = new boolean[n][finalSum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= finalSum; target++) {
                boolean pick = false;
                boolean notPick = dp[index - 1][target];
                if (arr[index] <= target) {
                    pick = dp[index - 1][target - arr[index]];
                }
                dp[index][target] = pick || notPick;
            }
        }
        return dp[n - 1][finalSum];
    }
}