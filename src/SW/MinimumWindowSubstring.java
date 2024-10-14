package SW;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }
        int[] hash = new int[256];

        int l = 0 , r = 0, count = 0, strIndex = -1, minLen = Integer.MAX_VALUE;
        for(Character c : t.toCharArray()){
            hash[c] += 1;
        }

        while(r < s.length()){

            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)] -= 1;
            while (count == t.length()){
                if(minLen > r-l + 1) {
                    minLen =  r - l + 1;
                    strIndex = l;
                }
                hash[s.charAt(l)]+= 1;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                l++;

            }
            r++;
        }
        return  strIndex == -1 ? "":s.substring(strIndex,strIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s,t));
    }
}
