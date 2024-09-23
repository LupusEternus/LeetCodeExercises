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


public class NinjaTraining_Tabulation {

    public static int ninjaTraining_Tab(int days, List<List<Integer>> points) {
        int[][] dp = new int[days][4];

        dp[0][0] = Math.max(points.get(0).get(1), points.get(0).get(2));
        dp[0][1] = Math.max(points.get(0).get(0), points.get(0).get(2));
        dp[0][2] = Math.max(points.get(0).get(0), points.get(0).get(1));
        dp[0][3] = Math.max(points.get(0).get(1), Math.max(points.get(0).get(0), points.get(0).get(2)));

        for (int day = 1; day < days; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int tempPoints = points.get(day).get(task) + dp[day - 1][task];
                        maxi = Math.max(maxi, tempPoints);
                    }
                }
                dp[day][last] = maxi;

            }
        }
        return dp[days - 1][3];
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(1, 2, 5)));
        list.add(new ArrayList<>(List.of(3, 1, 1)));
        list.add(new ArrayList<>(List.of(3, 3, 3)));

        System.out.println(ninjaTraining_Tab(3, list)); //11
    }
}
