package DP;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapsack_Memorization_Map {

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        Map<String,Integer> mem = new HashMap<>();
       return f(weight,value,maxWeight,n-1,mem);

    }


    private static int f(int[] weights, int[] values, int maxWeight, int index, Map<String,Integer> mem){
        String key = index + ":" + maxWeight;
        if(mem.containsKey(key)) return mem.get(key);


        if(maxWeight == 0){
            return 0;
        }
        if(index == 0){
            if(weights[0] <= maxWeight){
                return  values[0];
            }
            return 0;
        }
        int notPic = f(weights,values,maxWeight,index-1,mem);
        int pic =0;
        if(weights[index] <= maxWeight){
            pic = values[index] + f(weights,values,maxWeight-weights[index],index-1,mem);
        }
        mem.putIfAbsent(key,Math.max(notPic,pic));

        return Math.max(notPic,pic);
    }

    public static void main(String[] args) {
        int[] w = new int[]{1,2,4,5};
        int[] v = new  int[]{5,4,8,6};
        int maxW = 5;
        System.out.println(knapsack(w,v,w.length,maxW));
    }
}
