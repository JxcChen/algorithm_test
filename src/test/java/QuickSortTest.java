/**
 * ClassName: QuickSortTest
 * date: 2021/3/2 8:56
 *
 * @author JJJJ
 * Description:
 */
public class QuickSortTest {


    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr,0,arr.length-1);
//        quick_sort(arr,0,arr.length-1);
        for (int num : arr
        ) {
            System.out.println(num);
        }
    }


    public static void quickSort(int[] arr,int low,int high){
        // 先获取到数组low值
        int x = arr[low];
        int i = low;
        int j = high;
        // 当low<high时进行排序
        if (low < high){
            while (i < j){
                // 从右往左找，找到第一个比x小的元素 找到后放在low的位置中
                while (i < j && arr[j] >= x)
                    j--;

                if (i < j){
                    arr[i++] = arr[j];
                }
                // 从左往右找，找到第一个比x大的元素 找到后放在high的位置中
                while (i < j && arr[i] < x)
                    i++;
                if (i < j){
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);
        }


    }



    //快速排序
    static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] <= x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }

    }


}
