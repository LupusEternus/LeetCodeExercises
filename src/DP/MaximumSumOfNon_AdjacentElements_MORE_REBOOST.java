package DP;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOfNon_AdjacentElements_MORE_REBOOST {

    public static int maximumSumOfNonAdjElements(List<Integer> list) {

        return helper(list, list.size()-1 );
    }

    private static int helper(List<Integer> list, int index) {
        if(index < 0){
            return 0;
        }
        if (index == 0) {
           return list.get(0);
        }
        int pick = list.get(index) + helper(list, index - 2);;
        int notpick = helper(list, index - 1);;

        return Math.max(pick, notpick);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 1, 4, 9));

        System.out.println(maximumSumOfNonAdjElements(arr));
    }

}
