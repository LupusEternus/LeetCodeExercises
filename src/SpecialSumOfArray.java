import java.util.ArrayList;
import java.util.List;

public class SpecialSumOfArray {


    public static int specialSum(ArrayList<Integer> arr, int n ){
        int sum = 0;

        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
            if(sum >= 10){
                sum = sum % 10;
                sum++;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(8, 7, 0, 1, 2));
        System.out.println(specialSum(list,5));
    }

}
