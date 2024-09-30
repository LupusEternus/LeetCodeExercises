package DP;

import java.util.List;

public class SubsetSumEqualToK {

    public static boolean subsetSumToK( int k, List<Integer> arr){

        return  f(0,0,k,arr);
    }

    private static boolean f(int i,int currSum, int k, List<Integer> arr) {

        if(currSum  == k) return true;
        if(i >= arr.size()) return false;

        currSum += arr.get(i);
        boolean pick = f(i+1,currSum,k,arr);
        currSum -= arr.get(i);
        boolean notPick = f(i+1,currSum,k,arr);

        return pick || notPick;
    }
}

