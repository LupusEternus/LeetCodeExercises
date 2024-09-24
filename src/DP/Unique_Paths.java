package DP;

public class Unique_Paths {

    public static int helper(int[][] matrix, int x_pos, int y_pos, int m, int n) {

        if (x_pos == m - 1 && y_pos == n - 1) {
            return 1;
        }
        int paths = 0;
        if (x_pos < matrix.length - 1) {
            paths += helper(matrix, x_pos + 1, y_pos, m, n);
        }
        if (y_pos < matrix[x_pos].length - 1) {
            paths += helper(matrix, x_pos, y_pos + 1, m, n);
        }
        return paths;

    }

    public static int uniquePaths(int m, int n) {

        int[][] matrix = new int[m][n];
        return helper(matrix, 0, 0, m, n);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }

}
