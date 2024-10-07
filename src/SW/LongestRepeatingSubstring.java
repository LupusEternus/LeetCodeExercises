package SW;

public class LongestRepeatingSubstring {

    public static int longestRepeatingSubstring(String str, int k) {

        int maxSeq = 0;
        int l =0;
        int r = 0;
        int maxLen = 0;
        int[] hash = new int[26];

        while(r < str.length()){
            hash[str.charAt(r) -'A'] += 1;
            maxSeq = Math.max(maxSeq, hash[str.charAt(r) -'A']);
            if((r-l + 1) - maxSeq <= k ){
                maxLen = Math.max(maxLen,r-l+1);
            }else {
                hash[str.charAt(l) - 'A'] -= 1;
                l++;
            }
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "ABCCAA";
        int k = 2;
        System.out.println(longestRepeatingSubstring(s,k));
    }
}
