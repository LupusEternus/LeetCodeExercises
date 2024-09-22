package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNon_AdjacentElements_Tabulation {

    public static int maximumSumOfNonAdjElements(List<Integer> list) {

        int[] dp = new int[list.size()];
        dp[0] = list.get(0);

        for(int i = 1; i < dp.length; i++){
            int pick = list.get(i);
            if(i > 1) {
                pick += dp[i - 2] ;
            }
            int notPick = dp[i-1] ;
            dp[i] = Math.max(pick,notPick);

        }



        return dp[list.size()-1];
    }



    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 1, 4, 9));

        System.out.println(maximumSumOfNonAdjElements(arr));
    }

}
