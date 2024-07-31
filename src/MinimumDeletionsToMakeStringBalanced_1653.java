import java.util.*;

public class MinimumDeletionsToMakeStringBalanced_1653 {
    public static int minimumDeletions(String s) {
        int b = 0;
        int del = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (b > 0) {
                    del++;
                    b--;
                }
            } else {
                b++;
            }
        }
        return del;
    }
}
