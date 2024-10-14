package SW;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDifferentIntegers {

    static public int subarraysWithKDistinct(int[] nums, int k) {
        int l = 0, r = 0, count1 = 0, count2 = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        while(r < nums.length){
            freq.put(nums[r], freq.getOrDefault(nums[r],0) + 1 );
            while(freq.size() > k){
                freq.put(nums[l], freq.getOrDefault(nums[l],0) - 1 );
                if(freq.get(nums[l]) <= 0){
                    freq.remove(nums[l]);
                }
                l++;
            }
            count1 +=  r-l +1;
            r++;
        }
        r = 0;
        l = 0;
        freq = new HashMap<>();
        while(r < nums.length) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            while (freq.size() > k - 1) {
                freq.put(nums[l], freq.getOrDefault(nums[l], 0) - 1);
                if (freq.get(nums[l]) <= 0) {
                    freq.remove(nums[l]);
                }
                l++;
            }
            count2 += r - l + 1;
            r++;
        }
        return  count1 - count2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(arr,k));
    }
}
