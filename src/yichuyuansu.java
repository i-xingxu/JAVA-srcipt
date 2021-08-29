public class yichuyuansu {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[j]=nums[i];
                j+=1;
            }

        }
        return j;
    }

    public static void main(String[] args) {
        yichuyuansu y =new yichuyuansu();
        int [] nums= {3,2,2,3};
        int res=y.removeElement(nums,3);
        System.out.println(res);

    }
}
