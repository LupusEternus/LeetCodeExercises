package SW;

/*
Problem statement
Given a binary array 'ARR' of size 'N', your task is to find the longest sequence of continuous 1’s that can be formed by replacing at-most 'K' zeroes by ones.
Return the length of this longest sequence of continuous 1’s.
 */

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnesIII_Optimized {

    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {

        int l = 0, r = 0, maxLen = 0, zeros = 0;
        while (r < n) {
            if (arr.get(r) == 0) {
                zeros++;
            }
            if (zeros > k) {
                if (arr.get(l) == 0) {
                    zeros--;
                }
                l++;
            }
            if (zeros <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,0,0, 1, 1, 0, 1  ));
        System.out.println(longestSubSeg(list,list.size(),1));

    }
}
