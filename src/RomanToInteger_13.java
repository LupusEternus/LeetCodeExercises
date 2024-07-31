import java.util.*;

public class RomanToInteger_13 {

    public int romanToInt(String s) {
        int rom = 0;
        int prev = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = s.length() - 1; i >= 0; i--) {
            if (map.get(s.charAt(i)) < prev) {
                rom -= map.get(s.charAt(i));
            } else {
                rom += map.get(s.charAt(i));
                prev = map.get(s.charAt(i));
            }
        }
        return rom;
    }
}
