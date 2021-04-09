package medium_sort_test;

/**
 * @author: JJJJ
 * @date:2021/4/7 9:21
 * @Description: TODO
 */
public class Test03 {



    public boolean search(int[] nums, int target) {

        /**
         * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
         *
         * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
         *
         * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
         */

        // for(int num : nums){
        //     if(num == target)
        //         return true;
        // }
        // return false;
        int len = nums.length;
        // 双分指判断
        // if(nums.length == 1 ){
        //     if(nums[0] == target)
        //         return true;
        // }else{
        //     int l=0,r=nums.length-1;
        //     while(l <= r){
        //         if(nums[l] == target)
        //             return true;
        //         l++;
        //         if(nums[r] == target)
        //             return true;
        //         r--;
        //     }
        // }
        // return false;

        // 二分法判断

        if(nums.length == 1 ){
            if(nums[0] == target)
                return true;
        }
        else{
            int l = 0,r = len-1;
            while(l <= r){
                // 获取中间索引
                int mid = (l + r)/2;
                // 先判断中间数值是否等于target
                if(nums[mid] == target){
                    return true;
                }
                // 判断左边界值和右边界值是否等于中间索引值
                if(nums[l] == nums[mid] && nums[r] == nums[mid]){
                    l++;
                    r--;
                }
                // 判断左边界和中间值的大小
                // 如果左边界比中间值小 则说明左边界到中间值是一个递增的排序
                else if(nums[l] <= nums[mid]){
                    // 判断左边界、中间值与target的大小
                    if(nums[l] <= target && target < nums[mid]){
                        // 说明target只可能在 l到mid-1之间
                        r = mid-1;
                    }else{
                        // 说明左边界到mid之间的数都大于target
                        // 所以target只可能存在于mid+1~r之间
                        l = mid + 1;
                    }
                }else {
                    // 下面是nums[l] > nums[mid]的情况
                    if (nums[mid] < target && target <= nums[len-1]) {
                        l = mid + 1;
                    } else {
                        // nums[mid] < target && target > nums[len-1] 的情况target只可能在l~（mid-1）之间存在
                        // nums[mid] > target 的情况因为mid往右的情况只会比nums[mid]的值要大所以target得值只可能在l~（mid-1）之间存在
                        r = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
