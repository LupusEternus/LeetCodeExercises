package DP;

import java.util.List;

public class SubsetSumEqualToK {

    public static boolean subsetSumToK(int n, int k, int[] arr) {

        return f(arr.length - 1, k, arr);
    }

    private static boolean f(int i, int target, int[] arr) {

        if (target == 0) return true;
        if (i == 0) return arr[0] == target;

        boolean notPick = f(i - 1, target, arr);
        boolean pick = false;
        if (target >= arr[i]) {
            target -= arr[i];
            pick = f(i - 1, target, arr);

        }

        return pick || notPick;
    }
}

