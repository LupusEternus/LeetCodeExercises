package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogJump {

    public static int frogJump(int target, ArrayList<Integer> heights) {
        int[] memo = new int[heights.size() + 1];
        Arrays.fill(memo, -1);
        return helper(heights.size() - 1, heights, memo);
    }


    private static int helper(int index, ArrayList<Integer> heights, int[] memo) {
        if (memo[index] != -1) {
            return memo[index];
        }
        if (index == 0) {
            return 0;
        }

        int right = Integer.MAX_VALUE;
        int left = helper(index - 1, heights, memo) + Math.abs(heights.get(index) - heights.get(index - 1));
        if (index > 1) {
            right = helper(index - 2, heights, memo) + Math.abs(heights.get(index) - heights.get(index - 2));
        }

        memo[index] = Math.min(left, right);
        return Math.min(left, right);
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(30, 10, 60, 10, 60, 50));

        System.out.println(frogJump(arr.size() - 1, arr));

    }
}
