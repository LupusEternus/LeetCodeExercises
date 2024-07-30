

public class MaximumSumOfTwoNonOverlappingSubarrays {

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sums = new int[A.length + 1];
        int maxLval = 0;
        int maxRval = 0;
        int result = 0;

        for (int i = 1; i <= A.length; i++)
            sums[i] = A[i - 1] + sums[i - 1];

        //L is at Leftmost, M is at RightMost
        for (int i = L; i <= A.length - M; i++) {
            int currLVal = sums[i] - sums[i - L];
            int currMVal = sums[i + M] - sums[i];
            maxLval = Math.max(maxLval, currLVal);
            result = Math.max(result, currMVal + maxLval);
        }

        //M is at LeftMost, L is at RightMost
        for (int i = M; i <= A.length - L; i++) {
            int currMVal = sums[i] - sums[i - M];
            int currLVal = sums[i + L] - sums[i];
            maxRval = Math.max(maxRval, currMVal);
            result = Math.max(result, currLVal + maxRval);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println();


    }


}
