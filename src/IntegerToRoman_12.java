public class IntegerToRoman_12 {


    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder temp = new StringBuilder();

        int index = 0;
        while (num > 0) {
            if (num >= vals[index]) {
                num -= vals[index];
                temp.append(romans[index]);
            }
            if (num < vals[index]) {
                index++;
            }
        }
        return temp.toString();
    }
}
