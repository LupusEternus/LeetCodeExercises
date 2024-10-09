package SW;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumKWithNegativesAndZeros {


    public static int getLongestSubarray(int []nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        int maxLen = 0;
        int sum =0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = Math.max(maxLen,i+1);
            }
            if(hash.containsKey(sum - k)){
                maxLen = Math.max(maxLen,i-hash.get(sum-k));
            }
            hash.putIfAbsent(sum,i);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 1, -1, -1, 0};
        int k = 0;
        System.out.println(getLongestSubarray(arr,k
        ));
    }
}
