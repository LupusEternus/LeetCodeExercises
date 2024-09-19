package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Problem statement
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities.
(Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day.
As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity.
Your task is to calculate the maximum number of merit points that Ninja can earn.
*/


public class NinjaTraining {

    public static int ninjaTraining(int days, List<List<Integer>> points) {
        Map<String, Integer> memory = new HashMap<>();
        return helper(days - 1, points, 3, memory);
    }

    private static int helper(int day, List<List<Integer>> points, int last, Map<String, Integer> memory) {
        String temp = day + ":" + last;

        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points.get(0).get(task));
                }
            }
            return maxi;
        }
        if (memory.containsKey(temp)) {
            return memory.get(temp);
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int currentPoints = points.get(day).get(task) + helper(day - 1, points, task, memory);
                maxi = Math.max(maxi, currentPoints);
            }
        }
        memory.put(temp, maxi);
        return maxi;

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1, 2, 5)));
        list.add(new ArrayList<>(List.of(3, 1, 1)));
        list.add(new ArrayList<>(List.of(3, 3, 3)));

        System.out.println(ninjaTraining(3, list));


    }

}
