import java.util.Arrays;

public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder temp = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length()) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            } else {
                temp.append(first.charAt(i));
                i++;
            }
        }
        return temp.toString();
    }

}
