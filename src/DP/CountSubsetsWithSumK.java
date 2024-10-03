package DP;

public class CountSubsetsWithSumK {

    public static int findWays(int[] num, int tar) {

        return f(num, tar, num.length - 1);
    }
    private static int f(int[] num, int target, int index) {

        if (index == 0) {
            if (target == 0 && num[0] == 0) return 2;
            if (target == 0 || num[0] == target) return 1;
            return 0;
        }
        int pick = 0;
        if (target - num[index] >= 0) {
            pick = f(num, target - num[index], index - 1);
        }
        int notPick = f(num, target, index - 1);

        return pick + notPick;
    }
}
