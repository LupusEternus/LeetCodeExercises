package DP;

public class MinSubsetSumDifference_Tabulation {

    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int index = 1; index < n; index++) {
            for (int dpSum = 1; dpSum <= sum; dpSum++) {
                boolean pic = false;
                if (dpSum >= arr[index]) {
                    pic = dp[index - 1][dpSum - arr[index]];
                }
                boolean notPic = dp[index - 1][dpSum];
                dp[index][dpSum] = pic || notPic;
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int dpSum = 0; dpSum <= sum; dpSum++) {
            if (dp[n - 1][dpSum]) {
                int currentDiff = Math.abs(sum - (2 * dpSum));
                diff = Math.min(diff, currentDiff);
            }
        }

        return diff;
    }
}
