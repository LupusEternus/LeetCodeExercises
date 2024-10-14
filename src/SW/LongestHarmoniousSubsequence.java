package SW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        int size = Integer.MIN_VALUE;
        Map<Integer,Integer> hash =new HashMap<>();
        for(int i : nums){
            hash.put(i,hash.getOrDefault(i,0) + 1);
        }
        for(int i : nums){
            int bigger =0;
            if(hash.containsKey(i + 1)){
                bigger = hash.get(i+1) + hash.get(i);
            }
            int smaller = 0;
            if(hash.containsKey(i - 1)){
                smaller = hash.get(i-1) +hash.get(i);
            }
            size = Math.max(size,Math.max(bigger,smaller));
        }
        return size;
    }

    public static void main(String[] args) {
        int[] test =new int[] {1,2,2,1};
        System.out.println(findLHS(test));
    }
}
