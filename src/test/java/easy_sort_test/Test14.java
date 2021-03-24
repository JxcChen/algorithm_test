package easy_sort_test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Test14
 * date: 2021/3/24 8:40
 *
 * @author JJJJ
 * Description:
 */
public class Test14 {



    /*
        请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
        numberOfBoxesi 是类型 i 的箱子的数量。
        numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
        整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
        返回卡车可以装载 单元 的 最大 总数。
     */

    public static void main(String[] args) {
        int[][] arrs = {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}};
        System.out.println(maximumUnits(arrs, 35));
    }




    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] temp;
        int res = 0;
        // 使用冒泡排序对 数组进行排序
//        for(int i = 0; i < boxTypes.length-1;i++){
//            for (int j = 0;j <boxTypes.length-1-i;j++){
//                if(boxTypes[j][1] <  boxTypes[j+1][1]){
//                    temp = boxTypes[j];
//                    boxTypes[j] = boxTypes[j+1];
//                    boxTypes[j+1] = temp;
//                }
//            }
//        }
        // 重写arrays的排序比较方法进行排序
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 返回o1[1] - o2[] 表示的是从小到大排序  返回o2[1] - o1[1]则表示小大到小
                return o2[1] - o1[1];
            }
        });


        for(int[] box : boxTypes){
            if(truckSize > box[0]){
                res += box[0] * box[1];
                truckSize -= box[0];
            }else{
                res += truckSize * box[1];
                truckSize = 0;
            }
        }
        return res;
    }



}
