package SW;

import java.util.HashMap;
import java.util.Map;

public class CountAllSubarraysWithGivenSumWithNegativesAndZerosOptimized {

    public static int findAllSubarraysWithGivenSum(int a[], int k) {
        int count = 0, r = 0, l = 0, currentSum = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0,1);
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            int remove = currentSum - k;
            if(hash.containsKey(remove)){
                count += hash.get(remove);
            }
            hash.put(currentSum,hash.getOrDefault(currentSum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(findAllSubarraysWithGivenSum(arr, k));
    }

}
