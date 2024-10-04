package DP;

import java.util.Arrays;

public class PartitionsWithGivenDifference_BackTracking_Memorization {

    public static int countPartitions(int n, int d, int[] arr) {

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        if (totalSum < d) return 0;
        if ((totalSum - d) % 2 != 0) return 0;

        int target = (totalSum - d) / 2;
        int[][] mem = new int[arr.length][target + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return f(n - 1, arr, target, mem);
    }

    private static int f(int index, int[] arr, int target, int[][] mem) {
        if (mem[index][target] != -1) return mem[index][target];
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }
        int notPick = f(index - 1, arr, target, mem);
        int pick = 0;
        if (arr[index] <= target) {
            pick = f(index - 1, arr, target - arr[index], mem);
        }
        mem[index][target] = pick + notPick;

        return notPick + pick;
    }
}
