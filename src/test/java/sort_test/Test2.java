package sort_test;

/**
 * ClassName: Test2
 * date: 2021/3/4 12:40
 *
 * @author JJJJ
 * Description:
 */
public class Test2 {

    /*
    给你一个数字数组 arr 。

    如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。

    如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

     */

    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        // int temp = 0;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }
        quickSort(arr,0,arr.length-1);
        for(int i = 1;i<arr.length-1;i++){
            if(arr[i]*2!=arr[i-1]+arr[i+1])
                return false;
        }
        return true;
    }

    public static void quickSort(int[] arr,int low,int high){

        if(low < high){
            int i = low;
            int j = high;
            int x = arr[low];
            while(i<j){
                while(i < j && arr[j] >= x)
                    j--;
                if(i<j)
                    arr[i++] = arr[j];
                while(i<j && arr[i] <= x)
                    i++;
                if(i<j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);
        }
    }
}
