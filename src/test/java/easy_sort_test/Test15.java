package easy_sort_test;

import java.util.Arrays;

/**
 * ClassName: Test15
 * date: 2021/3/29 11:52
 *
 * @author JJJJ
 * Description:
 */
public class Test15 {
    /*
    给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
    如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。

     */

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] newArr = new int[101];
        Arrays.fill(newArr, -1);// 所有值初始化为 -1，方便后面判断
        // 将pieces的索引和第一个值对应 储存到newArr中
        for(int i=0;i < pieces.length;i++){
            newArr[pieces[i][0]] = i;  // 值作为索引  索引作为值
        }

        for(int i = 0;i < arr.length ;){
            // 查看newArr中是否有 arr中的值
            int num = newArr[arr[i]];
            i++;
            // 不为-1说明有相对应的值
            if(num != -1 ){
                // 从1开始判断是因为 第一个 已经在外层对比了
                for(int j = 1; j < pieces[num].length;j++){
                    if(arr[i] != pieces[num][j])
                        return false;
                    i++;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
