package DP;

public class CountSortedVowelStrings_1641 {

    public static int countVowelString(int n) {

        int noVowels = 5;
        int[][] matrix = new int[n][noVowels];
        for (int i = 0; i < noVowels; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            matrix[i][0] = matrix[i - 1][0] + matrix[i - 1][1] + matrix[i - 1][2] + matrix[i - 1][3] + matrix[i - 1][4];
            matrix[i][1] = matrix[i - 1][1] + matrix[i - 1][2] + matrix[i - 1][3] + matrix[i - 1][4];
            matrix[i][2] = matrix[i - 1][2] + matrix[i - 1][3] + matrix[i - 1][4];
            matrix[i][3] = matrix[i - 1][3] + matrix[i - 1][4];
            matrix[i][4] = matrix[i - 1][4];
        }
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[n - 1][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countVowelString(3));
    }

}
