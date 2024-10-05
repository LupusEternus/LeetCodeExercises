package DP;

public class ZeroOneKnapsack_Tabulation_SpaceOptimized {

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];
        int[] current = new int[maxWeight+1];

        for(int i = 1; i <= maxWeight; i++){
            if(weight[0] <= i){
                prev[i] = value[0];
            }
        }
        for(int index = 1; index < n; index++){
            for(int w = 1; w <= maxWeight; w++){
                int notPick = prev[w];
                int pick = 0;
                if(weight[index] <= w){
                    pick = value[index] + prev[w - weight[index]];
                }
                current[w] = Math.max(pick,notPick);
            }
            System.arraycopy(current, 0, prev, 0, maxWeight + 1);
        }
        return prev[maxWeight];
    }
    public static void main(String[] args) {
        int[] w = new int[]{1,2,4,5};
        int[] v = new  int[]{5,4,8,6};
        int maxW = 5;
        System.out.println(knapsack(w,v,w.length,maxW));
    }
}
