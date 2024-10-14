package patterns;

public class Pattern8_ReverseStarTriangle {

    public static void nStarTriangle(int n) {
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
        nStarTriangle(3);
    }
}
