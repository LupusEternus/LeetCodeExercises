package DP;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOfNon_AdjacentElements {

    public static int maximumSumOfNonAdjElements(List<Integer> list) {

        return helper(list, 0, 0);
    }

    private static int helper(List<Integer> list, int index, int carrySum) {

        if (index >= list.size()) {
            return carrySum;
        }
        int pick = 0;
        int notpick = 0;

        //pick
        carrySum += list.get(index);
        pick = helper(list, index + 2, carrySum);

        //notpick
        carrySum -= list.get(index);
        notpick = helper(list, index + 1, carrySum);

        return Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 1, 4, 9));

        System.out.println(maximumSumOfNonAdjElements(arr));
    }

}
