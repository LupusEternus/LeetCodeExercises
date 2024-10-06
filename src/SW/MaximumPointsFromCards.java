package SW;

/*
Problem statement
Given an array 'arr' of size 'N' representing the points associated with each card, and an integer 'K' representing the number of cards to be taken.
We need to return the maximum score that can be obtained.
In each step, we can choose to take one card from either the beginning or the end of the row. We must take exactly ‘K’ cards.
The score is calculated as the sum of the points of the cards chosen.
 */

public class MaximumPointsFromCards {

    public static int maxPoints(int []arr , int K){

        int l = K - 1;
        int r = arr.length-1;
        int leftSum = 0;
        int currentSum = 0;
        int rightSum = 0;
        for(int i = 0 ; i < K ;i++){
            leftSum += arr[i];
        }
        int maxPoints = leftSum;

        while(leftSum > 0 ){
            leftSum -= arr[l];
            rightSum += arr[r];
            l--;
            r--;
            currentSum = leftSum + rightSum;
            maxPoints = Math.max(maxPoints,currentSum);

        }
        return maxPoints;

    }
}
