package RC;

import java.util.ArrayList;
import java.util.List;

import static utils.Print.printArrayList;

public class AllSubSeq {


    public static boolean f(String s,int i){

        if(i >= s.length()/2) return true;

        if(s.charAt(i) != s.charAt(s.length()-1-i)) {
            return false;
        }

        return f(s, i + 1);
    }

    public static void allSubSeq(int index, int size, ArrayList<Integer> array , ArrayList<Integer> carry){
        if(index == size){
            printArrayList(carry);
            if(carry.isEmpty()){
                System.out.println("{}");
            }
            System.out.println();
            return;
        }
        carry.add(array.get(index));
        allSubSeq(index + 1,size,array,carry);
        carry.remove(carry.size()-1);
        allSubSeq(index + 1,size,array,carry);

    }



    public static void main(String[] args) {

        String s = "6677887766";

        System.out.println(f(s,0));

        ArrayList<Integer> lista = new ArrayList<>(List.of(3,1,2));
        allSubSeq(0,3,lista,new ArrayList<>());

    }
}
