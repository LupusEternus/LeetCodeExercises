package DP;

import java.util.ArrayList;
import java.util.List;

public class NinjaTraining {

    public static int ninjaTraining(int days, List<List<Integer>> points){

        return helper(days -1,points,3);
    }

    private static int helper(int day, List<List<Integer>> points, int last) {

        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3;i++ ){
                if(i != last){
                    maxi = Math.max(maxi,points.get(0).get(i));
                }
            }
            return maxi;
        }

        int maxi = 0;
        for(int j = 0; j < 3;j++){
            if(j != last){
                int currentPoints = points.get(day).get(j) + helper(day-1,points,j);
                maxi = Math.max(maxi,currentPoints);
            }
        }
        return maxi;

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1,2,5)));
        list.add(new ArrayList<>(List.of(3,1,1)));
        list.add(new ArrayList<>(List.of(3,3,3)));

        System.out.println(ninjaTraining(3,list));


    }

}
