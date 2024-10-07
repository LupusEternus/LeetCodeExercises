package SW;

/*
You are visiting a farm that has a single row of fruit trees arranged from left to right.
The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit.
There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
 */

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    static public int totalFruit(int[] fruits) {

        Map<Integer, Integer> seq = new HashMap<>();
        int l = 0, r = 0, maxLen = 0;

        while (r < fruits.length) {

            seq.put(fruits[r], seq.getOrDefault(fruits[r], 0) + 1);
            if (seq.size() < 3) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                int temp = seq.get(fruits[l]);
                seq.put(fruits[l], temp - 1);
                if (seq.get(fruits[l]) <= 0) {
                    seq.remove(fruits[l]);
                }
                l++;
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(arr));
    }

}
