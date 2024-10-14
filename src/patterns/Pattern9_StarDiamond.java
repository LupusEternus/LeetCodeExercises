package patterns;

public class Pattern9_StarDiamond {

    public static void nStarDiamond(int n) {
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
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < (n * 2) - 1; j++){
                if(i <= j && j < (n * 2) - 1 - i ){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        nStarDiamond(3);
    }
}
