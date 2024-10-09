package SW;

public class CountAllSubarraysWithGivenSumWithNegativesAndZerosBruteForce {

    public static int findAllSubarraysWithGivenSum(int[] a, int k) {
        int count = 0, r = 0, l = 0;
        long currentSum = 0;

        for(int i = 0; i < a.length; i++){
            currentSum = 0;
            for(int j = i; j < a.length; j++){
                currentSum += a[j];
                if(currentSum == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        System.out.println(findAllSubarraysWithGivenSum(arr,k));
    }
    
}
