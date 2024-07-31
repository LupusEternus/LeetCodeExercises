import java.util.*;

public class FindTheDifferenceOfTwoArrays_2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1){set1.add(i);}
        for(int i : nums2){set2.add(i);}

        List<List<Integer>> diff = new ArrayList<>();
        diff.add(new ArrayList<>());
        diff.add(new ArrayList<>());

        for(Integer i : set1){
            if(!set2.contains(i)){
                diff.get(0).add(i);
            }
        }
        for(Integer i : set2){
            if(!set1.contains(i)){
                diff.get(1).add(i);
            }
        }
        return diff;



    }
}
