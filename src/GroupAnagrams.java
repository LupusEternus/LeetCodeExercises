import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> grouped = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            grouped.putIfAbsent(s, new ArrayList<>());
            grouped.get(s).add(strs[i]);
        }
        return new ArrayList<>(grouped.values());
    }
}



