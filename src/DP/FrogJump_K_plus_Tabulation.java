package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This is a follow-up question to “Frog Jump” discussed in the previous article. In the previous question, the frog was allowed
to jump either one or two steps at a time. In this question, the frog is allowed to jump up to ‘K’ steps at a time.
If K=4, the frog can jump 1,2,3, or 4 steps at every index.
*/

public class FrogJump_K_plus_Tabulation {

    public static int frogJump(int target, ArrayList<Integer> heights, int k){


        return helper(target,heights,k);

    }

    private static int helper(int target, List<Integer> heights, int k){
        int[] dp = new int[target];
        dp[0] = 0;


        for(int i = 1; i < dp.length; i++){
            int minEnergy = Integer.MAX_VALUE;
            for(int j = 1; j <= k;j++){
                if(i - j >= 0) {
                   int currentEnergy = dp[i - j] + Math.abs(heights.get(i - j) - heights.get(i));
                    minEnergy = Math.min(minEnergy,currentEnergy);
                }

            }
            dp[i] = minEnergy;

        }


        return dp[target-1];
    }
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(30,10,60,10,60,50));

        System.out.println(frogJump(arr.size(),arr,2));

    }

}
