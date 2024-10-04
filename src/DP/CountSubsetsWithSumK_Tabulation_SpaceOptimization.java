package DP;

public class CountSubsetsWithSumK_Tabulation_SpaceOptimization {

    public static int findWays(int[] num, int tar) {
        int[] prev =  new int[tar+1];
        if(num[0] == 0){
            prev[0] = 2;
        }
        else {
            prev[0] =1;
        }
        if(num[0] <= tar && num[0] != 0) prev[num[0]] = 1;
        for(int index = 1; index < num.length; index++){
            int[] current = new int[tar+1];
            current[0] = 1;
            for(int target = 0; target <= tar; target++){
                int notPick = prev[target];
                int pick = 0;
                if(target >= num[index]){
                    pick =prev[target - num[index]];
                }
               current[target] = pick + notPick;
            }
            prev = current;
        }
        return prev[tar];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1};
        System.out.println(findWays(arr,2));
    }
}
