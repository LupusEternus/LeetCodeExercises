package SW;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int kDistinctChars(int k, String str) {

        Map<Character,Integer> seq = new HashMap<>();
        int l = 0, r = 0, maxLen = 0;

        while(r < str.length()){
            seq.put(str.charAt(r), seq.getOrDefault(str.charAt(r),0) +1);
            if(seq.size() <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }else {
                seq.put(str.charAt(l),seq.getOrDefault(str.charAt(l),1) -1);
                if (seq.get(str.charAt(l)) <= 0){
                    seq.remove(str.charAt(l));
                }
                l++;
            }
            r++;
        }
        return maxLen;
    }
}
