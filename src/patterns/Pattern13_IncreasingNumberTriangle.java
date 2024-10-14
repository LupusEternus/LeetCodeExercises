package patterns;

public class Pattern13_IncreasingNumberTriangle {

    public static void nNumberTriangle(int n) {
        int number = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j <= i; j++){
                System.out.print(number);
                number++;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        nNumberTriangle(4);
    }


}
