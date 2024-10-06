package DP;

public class WaysToMakeCoinChange {


    public static long countWaysToMakeChange(int[] denominations, int value) {

        return f(denominations, value, denominations.length - 1);
    }

    private static long f(int[] coins, int target, int index) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            if (target % coins[0] == 0) {
                return 1;
            }
            return 0;
        }
        long notTake = f(coins, target, index - 1);
        long take = 0;
        if (target - coins[index] >= 0) {
            take = f(coins, target - coins[index], index);
        }
        return notTake + take;
    }
}
