package RC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Print.printArrayList;

public class CombinationSum_II_40_OPTIMIZED {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }


    public static void findCombinations(int[] candidates, int target, int index, List<Integer> carry, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(carry));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            carry.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i + 1, carry, ans);
            carry.remove(carry.size() - 1);
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        for (List<Integer> l : combinationSum2(arr, target)) {
            printArrayList(l);
            System.out.println();
        }

    }

}
