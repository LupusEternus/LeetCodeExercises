package DP;

import java.util.Arrays;

public class CountSubsetsWithSumK_Memorization {

    public static int findWays(int[] num, int tar) {
        int[][] mem = new int[num.length][tar+1];
        for(int[] row : mem){
            Arrays.fill(row,-1);
        }
        return f(num, tar, num.length - 1, mem);
    }
    private static int f(int[] num, int target, int index, int[][]mem) {
        if(mem[index][target] != -1) return mem[index][target];
        if (index == 0) {
            if (target == 0 && num[0] == 0) return 2;
            if (target == 0 || num[0] == target) return 1;
            return 0;
        }
        int pick = 0;
        if (target - num[index] >= 0) {
            pick = f(num, target - num[index], index - 1,mem);
        }
        int notPick = f(num, target, index - 1,mem);
        mem[index][target] = pick + notPick;

        return pick + notPick;
    }
}

