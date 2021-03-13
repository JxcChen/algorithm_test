package sort_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: Test3
 * date: 2021/3/5 8:22
 *
 * @author JJJJ
 * Description: 求交集
 */
public class Test3 {
//    public int[] intersection(int[] nums1, int[] nums2) {
        // HashSet<Integer> set = new HashSet<Integer>();
        // HashSet<Integer> resSet = new HashSet<Integer>();

        // for (int num: nums1
        //      ) {
        //     set.add(num);
        // }
        // for (int num: nums2
        //      ) {
        //     if (set.contains(num)){
        //         resSet.add(num);
        //     }
        // }
        // int[] resArr = new int[resSet.size()];
        // int i = 0;
        // for (int num: resSet
        //      ) {
        //     resArr[i++] = num;
        // }
        // return resArr;

        // 双子针查找
        // 先进行排序
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int length1 = nums1.length,length2 = nums2.length;
//        int[] resArr = new int[length1+length2];
//        // index是resArr的索引
//        int index = 0,index1 = 0,index2 = 0;
//        while(index1 < length1 && index2 < length2){
//            int value1 = nums1[index1],value2 = nums2[index2];
//            if(value1 == value2){
//                // 保证唯一性存入
//                if(index == 0 || resArr[index-1] != value1)
//                    resArr[index++] = value1;
//                // 找到相等值 索引都要增加
//                index1++;
//                index2++;
//            }
//            if(value1 > value2)
//                index2++;
//            if(value1 < value2)
//                index1++;
//        }
//        HashMap<Integer,String> map = new HashMap<Integer, String>();
//
//        return Arrays.copyOfRange(resArr,0,index);
//    }
}
