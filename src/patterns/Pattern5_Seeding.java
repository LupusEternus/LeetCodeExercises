package patterns;

public class Pattern5_Seeding {
    public static void seeding(int n) {
        for(int i = 1; i <= n ; i++){
            for (int j = n - i ; j >= 0 ; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        seeding(3);
    }
}
