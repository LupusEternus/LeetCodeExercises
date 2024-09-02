package DP;

import java.util.*;

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

        ArrayList<Integer> arr = new ArrayList<>(List.of(7, 4, 8, 2, 1, 3, 5, 6, 4, 2));

        System.out.println(frogJump(arr.size()-1,arr,4));

    }

}
