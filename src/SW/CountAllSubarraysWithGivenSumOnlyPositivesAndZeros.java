package SW;

public class CountAllSubarraysWithGivenSumOnlyPositivesAndZeros {

    public static int findAllSubarraysWithGivenSum(int a[], int k) {
        int count = 0, r = 0, l = 0;
        long currentSum = 0;

        while (r < a.length) {
            currentSum += a[r];
            while (l <= r && currentSum > k) {
                currentSum -= a[l];
                l++;
            }
            if (currentSum == k) {
                count++;
            }
            r++;
        }
        return count;
    }

}
