package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogJump_plus_Tabulation {

    public static int frogJump(int target, ArrayList<Integer> heights){
       int[] dp = new int[target];
       dp[0] = 0;
       for(int i = 1 ; i < target ; i++){

           int left = dp[i-1] + Math.abs(heights.get(i) - heights.get(i - 1));
           int right = Integer.MAX_VALUE;
           if(i > 1){
               right = dp[i-2] + Math.abs(heights.get(i) - heights.get(i-2));
           }
           dp[i] = Math.min(left,right);
       }


       return dp[target-1];
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(30,10,60,10,60,50 ));
        int n = arr.size();

        System.out.println(frogJump(n,arr));

    }
}
