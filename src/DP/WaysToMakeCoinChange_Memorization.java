package DP;

import java.util.Arrays;

public class WaysToMakeCoinChange_Memorization {


    public static long countWaysToMakeChange(int[] denominations, int value) {
        long[][] mem = new long[denominations.length][value+1];
        for(long[] row : mem){
            Arrays.fill(row,-1);
        }
        return f(denominations, value, denominations.length - 1,mem);
    }

    private static long f(int[] coins, int target, int index, long[][] mem) {
        if(mem[index][target] != -1) return mem[index][target];
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            if (target % coins[0] == 0) {
                return 1;
            }
            return 0;
        }
        long notTake = f(coins, target, index - 1,mem);
        long take = 0;
        if (target - coins[index] >= 0) {
            take = f(coins, target - coins[index], index,mem);
        }
        mem[index][target] = notTake + take;

        return notTake + take;
    }
}
