import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (diff.containsKey(temp)) {
                return new int[]{diff.get(temp), i};
            }
            diff.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
