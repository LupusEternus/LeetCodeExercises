package DP;

public class WaysToMakeCoinChange_Tabulation {


    public static long countWaysToMakeChange(int[] denominations, int value) {

        long[][] dp = new long[denominations.length][value + 1];
        for (int i = 0; i < denominations.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= value; i++) {
            if (i % denominations[0] == 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int index = 1; index < denominations.length; index++) {
            for (int target = 1; target <= value; target++) {
                long notTake = dp[index - 1][target];
                long take = 0;
                if (target - denominations[index] >= 0) {
                    take = dp[index][target - denominations[index]];
                }
                dp[index][target] = take + notTake;
            }
        }

        return dp[denominations.length - 1][value];
    }
}
