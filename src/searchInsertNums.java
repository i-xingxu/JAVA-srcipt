public class searchInsertNums {
    public int searchInsert(int[] nums, int target) {
        int mid = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {   //可以相等，此时只剩一个数字
            mid = (start + end) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (target == nums[mid]) {
                return mid;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        searchInsertNums s = new searchInsertNums();
        System.out.println(s.searchInsert(a, 0));
    }
}
