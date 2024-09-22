package RC;

import java.util.ArrayList;

import static utils.Print.printArrayList;

public class CombinationSum_39 {

    private static void combinationSum(int[] arr, int index, int target, ArrayList<Integer> carry) {

        if (index == arr.length) {
            if (target == 0) {
                printArrayList(carry);
                System.out.println();

            }
            return;
        }
        //pick
        if (arr[index] <= target) {
            carry.add(arr[index]);
            combinationSum(arr, index, target - arr[index], carry);
            carry.remove(carry.size() - 1);
        }
        //not pick
        combinationSum(arr, index + 1, target, carry);
    }


    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(arr, 0, target, new ArrayList<>());

    }
}
