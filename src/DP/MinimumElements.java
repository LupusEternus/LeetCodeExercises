package DP;

public class MinimumElements {

    public static int minimumElements(int[] num, int x) {
        int ans = f(num, x, num.length - 1);
        if (ans >= 1000000000) return -1;

        return ans;
    }

    private static int f(int[] num, int target, int index) {
        if (index == 0) {
            if (target % num[0] == 0) return target / num[0];
            return 1000000000;
        }
        int notTake = f(num, target, index - 1);
        int take = 1000000000;
        if (num[index] <= target) {
            take = 1 + f(num, target - num[index], index);
        }

        return Math.min(notTake, take);
    }

    public static void main(String[] args) {
        int n = 3;
        int x = 7;
        int[] arr = new int[]{1, 2, 3};
        System.out.println(minimumElements(arr, x));

    }
}
