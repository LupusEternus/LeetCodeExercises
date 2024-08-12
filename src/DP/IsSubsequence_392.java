package DP;

public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        int l = 0;
        int r = 0;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                l++;
            }
            r++;
            if (l == s.length()) {
                return true;
            }
        }
        return false;
    }
}
