package medium_sort_test;

/**
 * @author: JJJJ
 * @date:2021/4/8 14:28
 * @Description: TODO
 */
public class Test04 {
    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     */
    public int findMin(int[] nums) {
        // 使用二分法
        int len = nums.length;
        int l = 0,r = len-1;
        int min = nums[0];
        while(r > l){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[r]){
                // 当nums[mid] < nums[r] 时 说明最小值在 l到mid之间  右半边为从小到大的数
                r = mid;
            }else{
                // 当nums[mid] > nums[r] 时 说明最小值在 mid到r之间  mid+1 到 r中间会出现反转后的最小值
                l = mid+1;
            }
        }
        // 循环结束后 r 会等于 l 也就是 nums[l]和nums[r]都为最小值
        return nums[l];
    }


    /**
     * 这个在上题基础上 元素能够重复 需要判断相等的情况
     */
    public int findMin02(int[] nums) {
        int l = 0,r = nums.length - 1;
        while(r > l){
            int mid = l + (r-l)/2;
            if(nums[mid] == nums[r]){
                r--;
            }
            else if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1 ;
            }
        }
        return nums[r];
    }
}
