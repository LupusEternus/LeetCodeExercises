package SW;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public  int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        int maxLen = 0, i = 0 , j=0;

        Set<Character> set = new HashSet<>();

        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen,set.size());
            }else {
                set.remove(s.charAt(i));
                i++;
            }

        }
        return maxLen;
    }
}
