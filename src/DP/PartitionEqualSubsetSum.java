package DP;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] arr, int n) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        return f(n - 1, n, arr, target);
    }

    private static boolean f(int index, int size, int[] arr, int target) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        boolean pick = false;
        boolean notPick = f(index - 1, size, arr, target);
        if (arr[index] <= target) {
            pick = f(index - 1, size, arr, target - arr[index]);
        }

        return pick || notPick;
    }
}
