package RC;

import java.util.*;

import static utils.Print.printArrayList;

public class CombinationSum_II_40_NOT_OPTIMIZED {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        findUniqueComb(ans, seen, candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }

    public static void findUniqueComb(List<List<Integer>> ans, Set<List<Integer>> seen, int[] candidates, int target, int index, List<Integer> carry, int carrySum) {

        if (index == candidates.length) {

            if (carrySum == target) {
                carry.sort(Comparator.naturalOrder());
                if (!seen.contains(carry)) {
                    ans.add(new ArrayList<>(carry));
                    seen.add(new ArrayList<>(carry));
                }
            }
            return;
        }

        //pick
        carry.add(candidates[index]);
        carrySum += candidates[index];
        findUniqueComb(ans, seen, candidates, target, index + 1, carry, carrySum);
        //not pick
        carry.remove(carry.size() - 1);
        carrySum -= candidates[index];
        findUniqueComb(ans, seen, candidates, target, index + 1, carry, carrySum);
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
