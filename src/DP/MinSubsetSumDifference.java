package DP;

public class MinSubsetSumDifference {

    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return f(arr.length - 1, 0,sum, arr);
    }
    private static int f(int index, int currentSum, int sum, int[] arr) {
        if (index == 0) {
            currentSum += arr[0];
            currentSum *= 2;
            return Math.abs(currentSum - sum);
        }
        int notPick = f(index - 1, currentSum, sum, arr);
        int pic = f(index - 1, currentSum + arr[index], sum, arr);

        return Math.min(pic, notPick);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(minSubsetSumDifference(arr, arr.length));
    }
}
