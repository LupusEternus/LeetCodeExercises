package DP;

import java.util.*;

/*
This is a follow-up question to “Frog Jump” discussed in the previous article. In the previous question, the frog was allowed
to jump either one or two steps at a time. In this question, the frog is allowed to jump up to ‘K’ steps at a time.
If K=4, the frog can jump 1,2,3, or 4 steps at every index.
*/

public class FrogJump_K {

    public static int frogJump(int target, ArrayList<Integer> heights, int k){
        Map<Integer,Integer> mem = new HashMap<>();
        return helper(target,heights,k,mem);

    }

    private static int helper(int index, List<Integer> heights, int k, Map<Integer,Integer> mem){
        if(mem.containsKey(index)){
            return mem.get(index);
        }
        if(index == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= k ; i++){
            if(index - i >= 0 ){
                min = Math.min(helper(index-i,heights,k,mem) + Math.abs(heights.get(index) - heights.get(index-i)),min);
            }

        }
        mem.putIfAbsent(index,min);
        return min;

    }
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(30,10,60,10,60,50));

        System.out.println(frogJump(arr.size()-1,arr,2));

    }

}
