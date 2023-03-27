package 数据机构练习题.第二章;

import java.util.ArrayList;

/**
 * @author: JJJJ
 * @date:2022/10/10 17:24
 * @Description: Desc
 */
public class Test3_1 {

    public static void main(String[] args) {
        int[] arr = {2,3,6,7,10};
        int[] newArr = insertData(arr,0);
        for (int num: newArr
             ) {
            System.out.println(num);
        }
    }

    /**
     * 在由序数组中插入元素 并保持递增
     */
    public static int[] insertData(int[] arr, int x){
        int length = arr.length;
        // 需要对数组进行扩容 增加一位
        int[] newArr = resize(arr,1);
        for(int i = 0;i<length;i++){
            if (newArr[i] > x){
                //需要将当前元素向后搬移
                System.arraycopy(newArr,i,newArr,i+1,length - i);
                newArr[i] = x;
                return newArr;
            }
        }
        newArr[newArr.length - 1] = x;
        return newArr;
    }

    public static int[] resize(int[] arr,int newCap){
        int length = arr.length;
        int[] newArr = new int[length +newCap];
        System.arraycopy(arr, 0, newArr, 0, length);
        return newArr;
    }
}
