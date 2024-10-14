package patterns;

public class Pattern2_Half_Forest {
    public static void f(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
        }
    }

    public static void main(String[] args) {

        f(5);
    }
}
