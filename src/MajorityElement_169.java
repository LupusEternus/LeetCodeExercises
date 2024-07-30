public class MajorityElement_169 {

    //Boyer–Moore majority vote algorithm

    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = 0;
        for (int n : nums) {
            if (count == 0) maj = n;
            if (maj != n) count--;
            else count++;
        }
        return maj;
    }
}
