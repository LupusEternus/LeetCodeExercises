package DP;

import java.util.HashMap;
import java.util.Map;

public class SubsetSumEqualToK_Memorization {

    public static boolean subsetSumToK(int n, int k, int[] arr) {
        Map<String, Boolean> mem = new HashMap<>();
        return f(arr.length - 1, k, arr, mem);
    }

    private static boolean f(int i, int target, int[] arr, Map<String, Boolean> memo) {
        String key = i + ":" + target;
        if (memo.containsKey(key)) return memo.get(key);

        if (target == 0) return true;
        if (i == 0) return arr[i] == target;
        if (i < 0) return false;

        boolean notPick = f(i - 1, target, arr, memo);
        boolean pick = false;
        if (target >= arr[i]) {
            target -= arr[i];
            pick = f(i - 1, target, arr, memo);
        }
        boolean result = pick || notPick;
        memo.putIfAbsent(key, result);

        return result;
    }
}
