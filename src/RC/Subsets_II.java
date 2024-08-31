package RC;

/*
    Given an integer array nums that may contain duplicates, return all possible subsets(the power set)
    The solution set must not contain duplicate subsets. Return the solution in any order.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Print.printArrayList;

public class Subsets_II {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,ans,new ArrayList<>(),0);

        return ans;
    }

    private static void helper(int [] nums, List<List<Integer>> ans, ArrayList<Integer> carry,int index){
        ans.add(new ArrayList<>(carry));
        for(int i = index;i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            carry.add(nums[i]);
            helper(nums,ans,carry,i+1);
            carry.remove(carry.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        for(List<Integer> l : subsetsWithDup(nums)){
            System.out.print(l + ", ");

        }

    }


}
