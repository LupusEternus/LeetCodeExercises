package patterns;

public class Pattern11_nBinaryTriangle {

    public static void nBinaryTriangle(int n) {
        int binary = 1;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                binary = 1;
            }else {
                binary = 0;
            }
            for(int j = 0; j <=i; j++){
                System.out.print(binary);
                binary = 1 - binary;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        nBinaryTriangle(3);
    }

}
