package easy_sort_test;

/**
 * ClassName: Test11
 * date: 2021/3/19 16:42
 *
 * @author JJJJ
 * Description:
 */
public class Test11 {

    /*
    有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。

    给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
     */

    public static void main(String[] args) {
        int[] arr = {-1,2,4};
        int res = 0 + arr[0];
        System.out.println(res);
    }


    public int largestAltitude(int[] gain) {
        int max = 0;
        int res = 0;
        for(int num : gain){
            res += num;
            if(max < res)
                max = res;
        }
        return max;
    }
}
