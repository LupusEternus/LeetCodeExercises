package patterns;

public class Pattern1_NForest {

    public static void f(int n, int m){

        for(int i = 0; i < n ; i++){
            System.out.println();
            for (int j = 0; j < m; j++){
                System.out.print(" * ");
            }
        }
    }

    public static void main(String[] args) {

      f(5,5);
    }
}
