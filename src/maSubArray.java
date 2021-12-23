public class maSubArray {

    public static int subNum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //初始化，第一个数是第一个子数组的最大值
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int result = nums[0];
        //从1开始遍历，第一个值已经初始化
        for (int i = 1; i < nums.length; i++) {

            if (sum[i - 1] > 0) {
                sum[i] = sum[i - 1] + nums[i];
            } else {
                sum[i] = nums[i];
            }
            if (sum[i] > result) {
                result = sum[i];
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] arry = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int s = subNum(arry);
        System.out.println(s);

    }

}
