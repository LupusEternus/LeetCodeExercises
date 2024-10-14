package patterns;

public class Pattern12_numberCrown {
    public static void numberCrown(int n) {
        int space = 2 *(n-1);
        for(int i = 1 ; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for(int s = 1; s <= space  ;s++ ){
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            space -=2;
        }
    }

    public static void main(String[] args) {
        numberCrown(4);
    }

}
