import java.util.Arrays;

/**
 * @author: JJJJ
 * @date:2022/8/2 7:42
 * @Description: Desc
 */
public class EasyTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4,2,3};
        minOperations(nums,5);
    }


    public static int minOperations(int[] nums, int x) {
        // 题目要求是删除左边界或者右边界的和为x的元素 => 寻找中间和为sum(nums)-x的子数组
        // 题目要求需要返回最小值，即需要找到最长子数组
        int left = 0,right = 0;
        // 声明一个最长长度
        int maxLen = Integer.MIN_VALUE;
        // 确定target
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int target = sum - x;
        int tempSum = 0;
        int len = nums.length;
        while(right < len){
            // 增大窗口
            tempSum += nums[right++];
            // 缩小窗口
            while(target > tempSum && left < right){
                tempSum -= nums[left++];
            }
            // 找到目标值 进行储存
            if(tempSum == target){
                maxLen = Math.max(maxLen,(right - left));
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1: len - maxLen;
    }

}
