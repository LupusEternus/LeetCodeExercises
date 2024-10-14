package SW;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers_Optimized {

    public static int subarraysWithKDistinct(int[] nums, int k) {


        return f(nums, k) - f(nums, k - 1);
    }


    private static int f(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, l = 0, r = 0;

        while(r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) <= 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
