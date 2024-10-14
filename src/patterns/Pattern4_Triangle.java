package patterns;

public class Pattern4_Triangle {
    public static void nTriangle(int n) {
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j <= i ; j++){
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {

        nTriangle(5);
    }
}
