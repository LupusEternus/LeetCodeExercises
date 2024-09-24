package DP;

public class Unique_Paths {

    public static int helper(int x_pos, int y_pos, int m, int n) {

        if (x_pos == m - 1 && y_pos == n - 1) {
            return 1;
        }
        int paths = 0;
        if (x_pos < m) {
            paths += helper(x_pos + 1, y_pos, m, n);
        }
        if (y_pos < n) {
            paths += helper( x_pos, y_pos + 1, m, n);
        }
        return paths;

    }

    public static int uniquePaths(int m, int n) {

        return helper(0, 0, m, n);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }

}
