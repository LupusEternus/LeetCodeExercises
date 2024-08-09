package DP;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 1) {
            return new ArrayList<>(List.of(1));
        }
        List<Integer> prev = new ArrayList<>(List.of(1, 1));
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(prev.get(j) + prev.get(j - 1));
            }
            result.add(1);
            prev = result;
        }

        return result;

    }

}
