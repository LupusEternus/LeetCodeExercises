public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n < 1) return;

        int[] helper = new int[m];
        for (int i = 0; i < helper.length; i++) {
            helper[i] = nums1[i];
        }

        int l = helper.length - 1;
        int r = nums2.length - 1;
        int i = nums1.length - 1;

        while (l >= 0 && r >= 0) {
            if (nums2[r] > helper[l]) {
                nums1[i] = nums2[r];
                i--;
                r--;
            } else {
                nums1[i] = helper[l];
                l--;
                i--;
            }
        }
        while (l >= 0) {
            nums1[i] = helper[l];
            i--;
            l--;
        }
        while (r >= 0) {
            nums1[i] = nums2[r];
            i--;
            r--;
        }
    }
}
