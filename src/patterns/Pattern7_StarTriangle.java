package patterns;

public class Pattern7_StarTriangle {

    public static void nStarTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (2 * n) - 1; j++) {
                if (j <= n + i - 1 && j  >= n - i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        nStarTriangle(3);
    }
}
