package sort_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * ClassName: Test1
 * date: 2021/3/3 12:28
 *
 * @author JJJJ
 * Description:给定两个数组，编写一个函数来计算它们的交集。
 */
public class Test1 {


    public static void main(String[] args) {
        int[] nums1 = {1,23,5,7,22,3};
        int[] nums2 = {1,23,5,7};
        int[] intersection = intersection(nums1, nums2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.println(intersection[i]);
        }
    }

    public  static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> resSet = new HashSet<Integer>();

        for (int num: nums1
             ) {
            set.add(num);
        }
        for (int num: nums2
             ) {
            if (set.contains(num)){
                resSet.add(num);
            }
        }
        int[] resArr = new int[resSet.size()];
        int i = 0;
        for (int num: resSet
             ) {
            resArr[i++] = num;

        }
        return resArr;
    }

}
