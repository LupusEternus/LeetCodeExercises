package DP;

public class MaximumPathSumInTheMatrix {

    public static int getMaxPathSum(int[][] matrix) {

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            int sum = f(matrix.length-1,i,matrix);
            result = Math.max(sum,result);
        }

        return result;
    }

    private static int f(int x, int y, int[][] matrix){

        if (x == 0){
            return matrix[x][y];
        }
        int d = Integer.MIN_VALUE;
        int dl = Integer.MIN_VALUE;
        int dr = Integer.MIN_VALUE;


        if(x > 0){
            d = matrix[x][y] + f(x-1,y,matrix);
        }
        if(x > 0 && y < matrix.length -1){
            dl = matrix[x][y] + f(x-1,y+1,matrix);
        }
        if(x > 0 && y > 0 ){
            dr = matrix[x][y] + f(x-1,y-1,matrix);
        }
        return Math.max(d,Math.max(dl,dr));

    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        System.out.println(getMaxPathSum(grid));
    }

}
