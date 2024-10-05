package DP;

public class ZeroOneKnapsack_Tabulation {

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];

        for(int i = 1; i <= maxWeight; i++){
            if(weight[0] <= i){
                dp[0][i] = value[0];
            }
        }
        for(int index = 1; index < n; index++){
            for(int w = 1; w <= maxWeight; w++){
                int notPick = dp[index-1][w];
                int pick = 0;
                if(weight[index] <= w){
                    pick = value[index] + dp[index-1][w - weight[index]];
                }
                dp[index][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][maxWeight];
    }
    public static void main(String[] args) {
        int[] w = new int[]{1,2,4,5};
        int[] v = new  int[]{5,4,8,6};
        int maxW = 5;
        System.out.println(knapsack(w,v,w.length,maxW));
    }
}
