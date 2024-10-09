package SW;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSum_Optimized {

    public  static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0, currentSum = 0;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            int remove = currentSum - goal;
            if(prefixSum.containsKey(remove)){
                count += prefixSum.get(remove);
            }
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int goal = 2;
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,goal));
    }



}
