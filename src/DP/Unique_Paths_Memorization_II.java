package DP;

import java.util.HashMap;
import java.util.Map;

public class Unique_Paths_Memorization_II {

    public static int helper(int x_pos, int y_pos, int m, int n, int[][] mem) {

        if(mem[x_pos][y_pos] != -1){
            return mem[x_pos][y_pos];
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
        mem[x_pos][y_pos] = paths;
        return paths;
    }

    public static int uniquePaths(int m, int n) {

        int[][] array = {
                {-1, -1, -1, -1},
                {-1, -1, -1, -1},
                {-1, -1, -1, -1},
                {-1, -1, -1, -1}
        };


        return helper(m - 1, n - 1, m, n, array);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
    }

}
