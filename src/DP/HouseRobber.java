package DP;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber {


    public static int houseRobber(List<Integer> list) {


        List<Integer> list1 = new ArrayList<>(List.copyOf(list));
        list1.remove(0);

        List<Integer> list2 = new ArrayList<>(List.copyOf(list));
        list2.remove(list2.size() - 1);


        int ans1 = helper(list1.size() - 1, list1);
        int ans2 = helper(list2.size() - 1, list2);

        return Math.max(ans1, ans2);
    }

    private static int helper(int index, List<Integer> values) {

        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return values.get(0);
        }

        int pick = values.get(index) + helper(index - 2, values);
        int notpick = helper(index - 1, values);


        return Math.max(pick, notpick);
    }


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 3, 2));

        System.out.println(houseRobber(arr));

    }


}
