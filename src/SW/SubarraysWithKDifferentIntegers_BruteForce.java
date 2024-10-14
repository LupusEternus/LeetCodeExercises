package SW;

import java.util.*;

public class SubarraysWithKDifferentIntegers_BruteForce{

    public int subarraysWithKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            set= new HashSet<>();
            for(int j = i ; j < nums.length; j++){
                set.add(nums[j]);
                if(set.size() == k) count++;
            }
        }
        return  count;
    }
}
