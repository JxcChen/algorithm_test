package easy_sort_test;

import java.util.Arrays;

/**
 * @author: JJJJ
 * @date:2021/7/14 15:22
 * @Description: TODO
 */
public class Test16 {
    /*
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {


        // 哈希表法
        // int len = nums.length;
        // if(len == 1)
        //     return nums[0];
        // int n = len/2;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0;i<len;i++){
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i],1);
        //     }else{
        //         int count = map.get(nums[i]);
        //         if(count + 1 > n){
        //             return nums[i];
        //         }else{
        //             map.put(nums[i],count+1);
        //         }
        //     }
        // }
        // return 0;
        //


        // 投票算法
        // int count = 0;
        // Integer candidate = null;

        // for (int num : nums) {
        //     if (count == 0) {
        //         candidate = num;
        //     }
        //     count += (num == candidate) ? 1 : -1;
        // }

        // return candidate;

        // 排序 获取中位数
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
