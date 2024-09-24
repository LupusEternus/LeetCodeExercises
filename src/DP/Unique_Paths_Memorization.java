package DP;

import java.util.HashMap;
import java.util.Map;

public class Unique_Paths_Memorization {

    public static int helper(int x_pos, int y_pos, int m, int n, Map<String, Integer> mem) {

        String pos = x_pos + ":" + y_pos;
        if (mem.containsKey(pos)) {
            return mem.get(pos);
        }
        if (x_pos == 0 && y_pos == 0) {
            return 1;
        }
        int paths = 0;
        if (x_pos > 0) {
            paths += helper(x_pos - 1, y_pos, m, n, mem);
        }
        if (y_pos > 0) {
            paths += helper(x_pos, y_pos - 1, m, n, mem);
        }
        mem.putIfAbsent(pos, paths);

        return paths;
    }

    public static int uniquePaths(int m, int n) {

        Map<String, Integer> mem = new HashMap<>();

        return helper(m - 1, n - 1, m, n, mem);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
    }

}
