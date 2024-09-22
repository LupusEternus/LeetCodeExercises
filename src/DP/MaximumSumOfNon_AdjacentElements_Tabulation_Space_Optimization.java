package DP;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOfNon_AdjacentElements_Tabulation_Space_Optimization {

    public static int maximumSumOfNonAdjElements(List<Integer> list) {


        int prev = list.get(0);
        int prev2 = 0;

        for(int i = 1; i < list.size(); i++){
            int current = list.get(i);
            if(i > 1) {
                current += prev2 ;
            }
            current = Math.max(current,prev);
            prev2 = prev;
            prev =current;
        }
        return prev;
    }



    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(2, 1, 4, 9));

        System.out.println(maximumSumOfNonAdjElements(arr));
    }

}
