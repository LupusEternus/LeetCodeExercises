package DP;


/*
Problem statement
You are given an array ‘ARR’ of ‘N’ integers and a target number, ‘TARGET’. Your task is to build an expression out of an array by adding one of the symbols '+' and '-'
before each integer in an array, and then by concatenating all the integers, you want to achieve a target. You have to return the number of ways the target can be achieved.
 */

public class TargetSum {

    public static int targetSum(int n, int target, int[] arr) {

        return f(target, arr, n - 1);
    }

    private static int f(int target, int[] arr, int index) {

        if (index < 0) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        int sub = 0;
        int add = 0;
        sub += f(target - arr[index], arr, index - 1);
        add += f(target + arr[index], arr, index - 1);

        return sub + add;
    }
}
