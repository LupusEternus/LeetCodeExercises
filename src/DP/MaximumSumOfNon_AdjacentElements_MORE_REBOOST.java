package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNon_AdjacentElements_MORE_REBOOST {

    public static int maximumSumOfNonAdjElements(List<Integer> list) {
        int[] seen = new int[list.size() + 1];
        Arrays.fill(seen, -1);
        return helper(list, list.size() - 1, seen);
    }

    private static int helper(List<Integer> list, int index, int[] seen) {

        if (index < 0) {
            return 0;
        }
        if (seen[index] != -1) {
            return seen[index];
        }
        if (index == 0) {
            return list.get(0);
        }
        int pick = list.get(index) + helper(list, index - 2, seen);
        int notpick = helper(list, index - 1, seen);

        seen[index] = Math.max(pick, notpick);
        return Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 1, 4, 9));

        System.out.println(maximumSumOfNonAdjElements(arr));
    }

}
