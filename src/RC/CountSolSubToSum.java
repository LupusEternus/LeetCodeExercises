package RC;

import java.util.ArrayList;
import java.util.List;

import static utils.Print.printArrayList;

public class CountSolSubToSum {

    private static int countSolSubToSum(int index, ArrayList<Integer> arr, int sum, ArrayList<Object> carry, int sumCarry) {

        if (index == arr.size()) {
            if (sumCarry == sum) {
                printArrayList(carry);
                System.out.println();
                return 1;
            }
            return 0;
        }
        carry.add(arr.get(index));
        sumCarry += arr.get(index);
        int l = countSolSubToSum(index + 1, arr, sum, carry, sumCarry);

        carry.remove(carry.size() - 1);
        sumCarry -= arr.get(index);
        int r = countSolSubToSum(index + 1, arr, sum, carry, sumCarry);

        return l + r;

    }


    public static void main(String[] args) {

        ArrayList<Integer> mojaLista = new ArrayList<>(List.of(1, 2, 1));
        int sum = 2;


        System.out.println("Number of solution(s) : " + countSolSubToSum(0, mojaLista, sum, new ArrayList<>(), 0));

    }


}
