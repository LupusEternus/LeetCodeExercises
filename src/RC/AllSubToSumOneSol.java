package RC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Print.printArrayList;

public class AllSubToSumOneSol {


    private static boolean allSubToSum(int index, ArrayList<Integer> carry,ArrayList<Integer> array,int target, int carrySum){
        if(index == array.size()){
            if(carrySum==target ){
               printArrayList(carry);
               System.out.println();
               return  true;
            }
            return false;
        }
        carry.add(array.get(index));
        carrySum += array.get(index);
        if(allSubToSum(index+1,carry,array,target,carrySum)){
           return true;
        }
        carrySum -= array.get(index);
        carry.remove(carry.size()-1);

        if(allSubToSum(index+1,carry,array,target,carrySum)){
            return true;
        }

        return  false;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(List.of(1,1,1,1,5,3,2));

        allSubToSum(0,new ArrayList<>(),list,5,0);



    }

}
