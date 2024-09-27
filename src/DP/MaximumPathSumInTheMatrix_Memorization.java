package DP;

import java.util.HashMap;
import java.util.Map;

public class MaximumPathSumInTheMatrix_Memorization {

    public static int getMaxPathSum(int[][] matrix) {
        Map<String,Integer> mem = new HashMap<>();
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            int sum = f(0,i,matrix,mem);
            result = Math.max(sum,result);
        }

        return result;
    }

    private static int f(int x, int y, int[][] matrix,Map<String,Integer> mem){
        String key = x + ":" + y;
        if(mem.containsKey(key)) return mem.get(key);

        if (x == matrix.length -1){
            return matrix[x][y];
        }
        int d = Integer.MIN_VALUE;
        int dl = Integer.MIN_VALUE;
        int dr = Integer.MIN_VALUE;


        if(x < matrix.length -1){
            d = matrix[x][y] + f(x+1,y,matrix,mem);
        }
        if(x < matrix.length -1 && y > 0){
            dl = matrix[x][y] + f(x+1,y-1,matrix,mem);
        }
        if(x < matrix.length -1 && y < matrix[x].length -1){
            dr = matrix[x][y] + f(x+1,y+1,matrix,mem);
        }
        int result = Math.max(d,Math.max(dl,dr));
        mem.putIfAbsent(key,result);
        return result;

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
