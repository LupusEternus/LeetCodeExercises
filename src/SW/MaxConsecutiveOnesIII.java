package SW;

/*
Problem statement
Given a binary array 'ARR' of size 'N', your task is to find the longest sequence of continuous 1’s that can be formed by replacing at-most 'K' zeroes by ones.
Return the length of this longest sequence of continuous 1’s.
 */

import java.util.ArrayList;

public class MaxConsecutiveOnesIII {

    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {

        int l = 0, r = 0, maxLen = 0, zeros = 0;
        while (r < n) {
            if (arr.get(r) == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (arr.get(l) == 0) {
                    zeros--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
