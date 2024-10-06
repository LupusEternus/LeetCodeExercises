package DP;

/*
Problem statement
You are given an array ‘ARR’ of ‘N’ integers and a target number, ‘TARGET’. Your task is to build an expression out of an array by adding one of the symbols '+' and '-'
before each integer in an array, and then by concatenating all the integers, you want to achieve a target. You have to return the number of ways the target can be achieved.
 */

import java.util.HashMap;
import java.util.Map;

public class TargetSum_Memorization {

    public static int targetSum(int n, int target, int[] arr) {
        Map<String, Integer> mem = new HashMap<>();
        return f(target, arr, n - 1, mem);
    }

    private static int f(int target, int[] arr, int index, Map<String, Integer> mem) {
        String key = index + ":" + target;
        if (mem.containsKey(key)) return mem.get(key);

        if (index < 0) {
            return target == 0 ? 1 : 0;
        }

        int sub = f(target - arr[index], arr, index - 1, mem);
        int add = f(target + arr[index], arr, index - 1, mem);
        mem.putIfAbsent(key, sub + add);

        return sub + add;
    }
}
