package DP;

public class MinimumPathSum {

    public static int minSumPath(int[][] grid){

        int carrySum = 0;
        int n = grid.length - 1;
        int m = grid[0].length - 1;

        return f(grid,carrySum,n,m);
    }

    private static int f(int[][] grid, int currSum, int x , int y ){

        if(x == 0 && y == 0){
            currSum+= grid[0][0];
            return currSum;
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        currSum += grid[x][y];

        if(x > 0){
            up = f(grid,currSum,x -1,y);
        }
        if(y > 0){
            left = f(grid,currSum,x,y-1);
        }
        return Math.min(up,left);

    }



    public static void main(String[] args) {

        int[][] grid = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println(minSumPath(grid));
    }
}
