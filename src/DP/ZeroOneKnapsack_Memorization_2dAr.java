package DP;

import java.util.Arrays;


public class ZeroOneKnapsack_Memorization_2dAr {

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] mem = new int[n][maxWeight+1];
        for(int[] row : mem){
            Arrays.fill(row,-1);
        }

        return f(weight,value,maxWeight,n-1,mem);
    }

    private static int f(int[] weights, int[] values, int maxWeight, int index, int[][] mem){
        if(mem[index][maxWeight] != -1)return mem[index][maxWeight];
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
        mem[index][maxWeight] = Math.max(notPic,pic);
        return Math.max(notPic,pic);
    }

    public static void main(String[] args) {
        int[] w = new int[]{1,2,4,5};
        int[] v = new  int[]{5,4,8,6};
        int maxW = 5;
        System.out.println(knapsack(w,v,w.length,maxW));
    }
}
