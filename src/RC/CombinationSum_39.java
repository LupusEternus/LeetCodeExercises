package RC;

import java.util.ArrayList;
import java.util.List;

import static utils.Print.printArrayList;

public class CombinationSum_39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        allCombinations(candidates, ans, 0, target, new ArrayList<>());
        return ans;

    }

    public static void allCombinations(int[] candidates, List<List<Integer>> ans, int index, int target, List<Integer> carry) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(carry));
            }
            return;
        }
        //pick
        if (candidates[index] <= target) {
            carry.add(candidates[index]);
            allCombinations(candidates, ans, index, target - candidates[index], carry);
            carry.remove(carry.size() - 1);
        }
        //not pick
        allCombinations(candidates, ans, index + 1, target, carry);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> list = combinationSum(arr, target);
        for (List<Integer> l : list) {
            printArrayList(l);
            System.out.println();
        }

    }
}
