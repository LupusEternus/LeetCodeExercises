package DP;

public class MaximumRepeatingSubstring_1668 {

    public int maxRepeating(String sequence, String word) {
        if (word.length() > sequence.length()) return 0;
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }
}
