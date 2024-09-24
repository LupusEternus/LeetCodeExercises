package DP;

import java.util.ArrayList;
import java.util.List;


/*
Problem statement
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities.
(Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day.
As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity.
Your task is to calculate the maximum number of merit points that Ninja can earn.
*/


public class NinjaTraining_Tabulation {

    public static int ninjaTraining_Tab(int days, List<List<Integer>> points) {
        int[][] dp = new int[days][days];

        dp[0][0] = points.get(0).get(0);
        dp[0][1] = points.get(0).get(1);
        dp[0][2] = points.get(0).get(2);

        for (int day = 1; day < days; day++) {
            for (int last = 0; last < 3; last++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if(task != last){
                        int current = points.get(day).get(task) + dp[day-1][last];
                        maxi = Math.max(maxi,current);
                    }
                }
                dp[day][last] = maxi;
            }

        }
        return Math.max(dp[days-1][0],Math.max(dp[days-1][1],dp[days-1][2]));
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1, 2, 5)));
        list.add(new ArrayList<>(List.of(3, 1, 1)));
        list.add(new ArrayList<>(List.of(3, 3, 3)));

        System.out.println(ninjaTraining_Tab(3, list)); //11
    }
}
