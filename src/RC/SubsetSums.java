package RC;


    /*
        Task:
        Given a list(arr) of N integer, print sums of all subsets in it(n max subset size). Output should be
        printed in increasing order of sums
    */


import java.util.PriorityQueue;

public class SubsetSums {


    public static void subsetSum(int[] arr, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        findAll(0, 0, arr, ans, k);
        while (!ans.isEmpty()) {
            System.out.print(ans.poll() + " ");
        }

    }

    private static void findAll(int index, int carrySum, int[] arr, PriorityQueue<Integer> aws, int k) {
        if (index == arr.length || k == 0) {
            aws.add(carrySum);
            return;
        }

        carrySum += arr[index];
        findAll(index + 1, carrySum, arr, aws, k - 1);
        carrySum -= arr[index];
        findAll(index + 1, carrySum, arr, aws, k);

    }


    public static void main(String[] args) {

        int n = 3;
        int[] arr = new int[]{1, 2, 1};
        subsetSum(arr, n);

    }


}
