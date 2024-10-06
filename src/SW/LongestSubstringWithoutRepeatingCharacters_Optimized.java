package SW;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters_Optimized {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int maxLen = 0, i = 0, j = 0, currentL = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while (j < s.length()) {
            if (hash[s.charAt(j)] != -1) {
                int position = hash[s.charAt(j)];
                if (position >= i) {
                    i = position + 1;
                }
            }
            currentL = j - i + 1;
            maxLen = Math.max(currentL, maxLen);
            hash[s.charAt(j)] = j;
            j++;
        }

        return maxLen;
    }
}
