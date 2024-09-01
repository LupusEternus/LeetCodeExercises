package RC;

/*
  Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
  leetcode.com/problems/permutations/description/
  Solution by recursion + free/taken slot mechanism
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] slots = new boolean[nums.length];
        helper(nums,ans,new ArrayList<>(),slots);

        return ans;
    }

    private static void helper(int[] nums,List<List<Integer>> ans, List<Integer> carry, boolean[] slots){
        if(carry.size() == nums.length){
            ans.add(new ArrayList<>(carry));
            return;
        }
        for (int i = 0; i< nums.length; i++){
            if(slots[i]) continue;
            carry.add(nums[i]);
            slots[i] = true;
            helper(nums,ans,carry,slots);
            carry.remove(carry.size()-1);
            slots[i] = false;

        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        for (List<Integer> l : permute(nums)){
            System.out.println(l + ",");
        }
    }

}
