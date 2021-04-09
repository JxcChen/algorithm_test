package medium_sort_test;

/**
 * @author: JJJJ
 * @date:2021/4/6 14:04
 * @Description: TODO
 */
public class Test02 {

    /**
     *
     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */


    /**
     * 使用双指针的方法
     */
    public int removeDuplicates(int[] nums) {
        // 先判断原数组长度是否大于2
        // 小于2则直接范围原数组长度
        int len = nums.length;
        if(len < 2){
            return len;
        }
        // 声明连个指针 slow quick
        // slow代表将要填入所需保存数值的索引 quick代表当前检查数值的索引
        int slow = 2 ,quick = 2;
        while(quick <= len-1){
            // 查看是否存在三个连续相同的元素
            // slow往前看两位 查看与正在检查的元素是否相等 相等则略过
            if(nums[slow-2] != nums[quick]){
                nums[slow] = nums[quick];
                slow++;
            }
            quick++;
        }
        // 返回slow的数值  slow代表新数组的长度
        return slow;
    }
}
