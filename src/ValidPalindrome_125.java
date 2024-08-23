public class ValidPalindrome_125 {

    public static boolean isPalindrome(String s) {
         s = s.trim().toLowerCase();
         s = s.replaceAll("[^a-z0-9]", "");
         int l = 0;
         int r = s.length() - 1;


        while(l < r ){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return  true;

    }


    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }


}
