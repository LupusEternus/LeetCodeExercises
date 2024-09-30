package DP;

import java.util.HashMap;
import java.util.Map;

public class SubsetSumEqualToK_Memorization {

    public static boolean subsetSumToK(int n, int k, int arr[]){
        Map<String, Boolean> mem = new HashMap<>();
        return  f(0,0,k,arr,mem);
    }

    private static boolean f(int i,int currSum, int k, int[] arr,Map<String, Boolean> mem) {
        String key = i + ":" + currSum;
        if(mem.containsKey(key)) return mem.get(key);

        if(currSum  == k) return true;
        if(i >= arr.length) return false;

        currSum += arr[i];
        boolean pick = f(i+1,currSum,k,arr,mem);
        currSum -= arr[i];
        boolean notPick =f(i+1,currSum,k,arr,mem);

        boolean result = pick || notPick;
        mem.putIfAbsent(key,result);

        return result;
    }
}
