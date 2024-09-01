package RC;


/*
  Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
  leetcode.com/problems/permutations/description/
  Solution by recursion + swap
*/

import java.util.ArrayList;
import java.util.List;

public class Permutation_II {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, 0, ans);

        return ans;

    }

    private static void helper(int[] nums, int index, List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            helper(nums, index + 1, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> l : permute(nums)) {
            System.out.println(l + ",");
        }
    }

}
