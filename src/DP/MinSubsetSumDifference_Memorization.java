package DP;

public class MinSubsetSumDifference_Memorization {

    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        Integer[][] mem = new Integer[n][sum + 1];

        return f(n - 1, 0, sum, arr, mem);
    }

    private static int f(int index, int currentSum, int sum, int[] arr, Integer[][] mem) {

        if (index < 0) {
            int sum2 = sum - currentSum;
            return Math.abs(currentSum - sum2);
        }
        if (mem[index][currentSum] != null) {
            return mem[index][currentSum];
        }
        int notPick = f(index - 1, currentSum, sum, arr, mem);
        int pic = f(index - 1, currentSum + arr[index], sum, arr, mem);
        mem[index][currentSum] = Math.min(pic, notPick);

        return Math.min(pic, notPick);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(minSubsetSumDifference(arr, arr.length));
    }
}
