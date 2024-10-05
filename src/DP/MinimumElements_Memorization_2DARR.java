package DP;

import java.util.Arrays;

public class MinimumElements_Memorization_2DARR {

    public static int minimumElements(int[] num, int x) {
        int[][] mem = new int[num.length][x + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        int ans = f(num, x, num.length - 1, mem);
        if (ans >= 1000000000) return -1;

        return f(num, x, num.length - 1, mem);
    }

    private static int f(int[] num, int target, int index, int[][] mem) {
        if (mem[index][target] != -1) return mem[index][target];
        if (index == 0) {
            if (target % num[0] == 0) return target / num[0];
            return 1000000000;
        }
        int notTake = f(num, target, index - 1, mem);
        int take = 1000000000;
        if (num[index] <= target) {
            take = 1 + f(num, target - num[index], index, mem);
        }
        int ans = Math.min(notTake, take);
        mem[index][target] = ans;

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int x = 7;
        int[] arr = new int[]{1, 2, 3};
        System.out.println(minimumElements(arr, x));
    }
}
