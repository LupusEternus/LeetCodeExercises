package SW;

public class LongestSubarrayWithSumKOnlyPositiveAndZeros {

    public static int longestSubarrayWithSumK(int[] a, long k) {
        int maxLen = 0, r = 0, l = 0;
        long currentSum = 0;

        while (r < a.length) {
            currentSum += a[r];
            while(l <= r && currentSum > k) {
                currentSum -= a[l];
                l++;
            }
            if (currentSum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }
}
