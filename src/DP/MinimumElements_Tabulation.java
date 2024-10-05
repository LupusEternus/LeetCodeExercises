package DP;

public class MinimumElements_Tabulation {

    public static int minimumElements(int[] num, int x) {

        int[][] dp = new int[num.length][x + 1];
        for (int i = 0; i <= x; i++) {
            if (i % num[0] == 0) {
                dp[0][i] = i / num[0];
            } else {
                dp[0][i] = 1000000000;
            }
        }
        for (int index = 1; index < num.length; index++) {
            for (int target = 0; target <= x; target++) {
                int notTake = dp[index - 1][target];
                int take = 1000000000;
                if (num[index] <= target) {
                    take = 1 + dp[index][target - num[index]];
                }
                dp[index][target] = Math.min(take, notTake);
            }
        }
        int ans = dp[num.length - 1][x];
        if (ans >= 1000000000) return -1;

        return ans;
    }

    public static void main(String[] args) {
        int x = 7;
        int[] arr = new int[]{1, 2, 3};
        System.out.println(minimumElements(arr, x));
    }
}
