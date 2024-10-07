package SW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {

    static public int numberOfSubstrings(String s) {
        int[] lastseen = new int[3];
        Arrays.fill(lastseen,-1);
        int counter = 0;
        for(int i = 0 ; i < s.length(); i++){
            lastseen[s.charAt(i) - 'a'] = i;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1 ){
                counter += 1 + Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2] ) );
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String  s = "abcabc";

        System.out.println(numberOfSubstrings(s));
    }

}
