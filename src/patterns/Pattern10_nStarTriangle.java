package patterns;

public class Pattern10_nStarTriangle {
    public static void nStarTriangle(int n) {
        for(int i = 1 ; i < n * 2; i++){
            for(int j = 1 ; j <= n; j++){
                if(j <= i && i <= (n *2) - j ){
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
