public class SearchInsertPosition_35 {

    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (mid < nums.length / 2) {
            while (mid >= 0 && nums[mid] < target) {
                mid++;
            }
        }
        if (mid >= nums.length / 2) {
            while (mid < nums.length && nums[mid] < target) {
                mid++;
            }
        }
        return mid;
    }
}


