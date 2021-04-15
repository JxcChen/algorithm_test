package medium_sort_test;

/**
 * @author: JJJJ
 * @date:2021/4/15 9:14
 * @Description: TODO
 */
public class Test05 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

     */

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return nums[0]>nums[1]? nums[0]:nums[1];
        return Math.max(maxRob(nums,0,len-2),maxRob(nums,1,len-1));
    }

    public int maxRob(int[] nums,int start,int end){
        int first = nums[start],second = Math.max(nums[start],nums[start+1]);
        for(int i = start + 2;i <= end;i++){
            // 先把second给到temp second是必定大于等于first
            int temp = second;
            // 判断second与 frist+nums[i]的大小 将较大值赋给second
            second = Math.max(second,first+nums[i]);
            // 将temp值赋给first 即把second原来值赋给second
            first = temp;
        }
        return second;
    }

}
