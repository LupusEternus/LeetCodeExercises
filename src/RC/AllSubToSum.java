package RC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Print.printArrayList;

public class AllSubToSum {

    private static final Set<ArrayList<Integer>> seen = new HashSet<>();

    private static void allSubToSum(int index, ArrayList<Integer> carry, ArrayList<Integer> array, int target, int carrySum) {
        if (index == array.size()) {
            if (carrySum == target) {
                if (!seen.contains(carry)) {
                    printArrayList(carry);
                    System.out.println();
                    seen.add(carry);
                }
            }
            return;
        }
        carry.add(array.get(index));
        carrySum += array.get(index);
        allSubToSum(index + 1, carry, array, target, carrySum);

        carrySum -= array.get(index);
        carry.remove(carry.size() - 1);
        allSubToSum(index + 1, carry, array, target, carrySum);

    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(List.of(1, 1, 1, 1, 5, 3, 2));
        allSubToSum(0, new ArrayList<>(), list, 5, 0);


    }

}
