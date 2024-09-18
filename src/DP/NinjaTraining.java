package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NinjaTraining {

    public static int ninjaTraining(int days, List<List<Integer>> points){
        Map<String,Integer> memory = new HashMap<>();
        return helper(days -1,points,3,memory);
    }

    private static int helper(int day, List<List<Integer>> points, int last,Map<String,Integer> memory) {
        String temp = day + ":" + last;

        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3;i++ ){
                if(i != last){
                    maxi = Math.max(maxi,points.get(0).get(i));
                }
            }
            return maxi;
        }
        if(memory.containsKey(temp)){
            return memory.get(temp);
        }


        int maxi = 0;
        for(int j = 0; j < 3;j++){
            if(j != last){
                int currentPoints = points.get(day).get(j) + helper(day-1,points,j,memory);
                maxi = Math.max(maxi,currentPoints);
            }
        }
        memory.put(temp,maxi);
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
