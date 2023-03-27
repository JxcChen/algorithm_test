package 数据机构练习题.第三章;

/**
 * @author: JJJJ
 * @date:2022/10/14 8:45
 * @Description: Desc
 */
public class Test3_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        reverse(arr);
        System.out.println("debug");
    }

    public static void reverse(int[] arr){
        int head = 0;
        int last = arr.length - 1;
        while (head<last){
            int temp = arr[head];
            arr[head] = arr[last];
            arr[last] = temp;
            head++;
            last--;
        }
    }
}
