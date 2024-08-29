package RC;

import java.util.ArrayList;
import java.util.List;

public class CountSolSubToSum {

    private static int countSolSubToSum(int index, ArrayList<Integer> arr, int sum, int sumCarry) {

        if (index == arr.size()) {
            if (sumCarry == sum) return 1;
            return 0;
        }
        sumCarry += arr.get(index);
        int l = countSolSubToSum(index + 1, arr, sum, sumCarry);

        sumCarry -= arr.get(index);
        int r = countSolSubToSum(index + 1, arr, sum, sumCarry);

        return l + r;

    }


    public static void main(String[] args) {

        ArrayList<Integer> mojaLista = new ArrayList<>(List.of(1, 3, 1, 2, 4, 6, 7, 2));
        int sum = 10;

        System.out.println("Number of solution(s) : " + countSolSubToSum(0, mojaLista, sum, 0));

    }


}
