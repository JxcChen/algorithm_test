package medium_sort_test;

import java.util.ArrayList;

/**
 * @author: JJJJ
 * @date:2021/4/15 9:14
 * @Description: TODO
 */
public class Test05 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
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
            // 原理： 将遍历到的数 非相邻的数的和最大值赋给second 不一定是相隔一位，可以是是相隔多位如：
            // [1,9,1,1,8,1,3]  前面4位中 非相邻情况下 8+9=17是最大的 所以就把17赋给17
            second = Math.max(second,first+nums[i]);
            // 将temp值赋给first 即把second原来的值赋给first
            // 因为second是保存了非相邻的最大和 所以first就是i以前最大的数之和 相当于存储前second的值
            first = temp;
        }

        return second;
    }

}
