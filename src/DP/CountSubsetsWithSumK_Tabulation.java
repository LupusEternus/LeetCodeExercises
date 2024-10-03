package DP;

public class CountSubsetsWithSumK_Tabulation {

    public static int findWays(int[] num, int tar) {
        int[][] dp = new int[num.length][tar+1];

        for(int i = 0; i < num.length; i++){
            if(i == 0 && num[i] == 0){
                dp[i][0] = 2;
            }else {
                dp[i][0] = 1;
            }
        }
        if(num[0] <= tar && num[0] != 0) dp[0][num[0]] = 1;

        for(int index = 1; index < num.length; index++){
            for(int target = 1; target <= tar; target++){
                int notPick = dp[index-1][target];
                int pick = 0;
                if(target >= num[index]){
                    pick = dp[index-1][target - num[index]];
                }
                dp[index][target] = pick + notPick;
            }
        }

        return dp[num.length-1][tar];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 14, 3, 18, 2 };
        System.out.println(findWays(arr,13));
    }
}
