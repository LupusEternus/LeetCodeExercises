package SW;

public class BinarySubArraysWithSum_BruteForce {

    public  static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int curentSum = 0;
            for(int j = i; j < nums.length; j++){
                curentSum += nums[j];
                if(curentSum == goal){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int goal = 2;
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,goal));
    }



}
