package easy_sort_test;

import java.util.HashMap;
import java.util.Set;

public class Test8 {
    /**
     * 给你两个数组，arr1 和arr2，
     * arr2中的元素各不相同
     * arr2 中的每个元素都出现在arr1中
     * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
     */


    /**
     * 使用map形式  最后再对arr2没有的数进行排序
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] resArr = new int[arr1.length];
        int index = 0;
        for(int num : arr2){
            int count = map.get(num);
            while(count > 0 && index < arr1.length){
                resArr[index++] = num;
                count--;
            }
            map.remove(num);
        }
        Set<Integer> set =  map.keySet();
        int t = index;
        for(int num : set){ 
            int count = map.get(num);
            while(count > 0 && index < arr1.length){
                resArr[index++] = num;
                count--;
            }
        }
        // for(int i = t ;i < arr1.length -1;i++){
        //     for(int j = t;j<arr1.length-1;j++){
        //         if(resArr[j] > resArr[j+1]){
        //             int temp = resArr[j];
        //             resArr[j] = resArr[j+1];
        //             resArr[j+1] = temp;
        //         }
        //     }
        // }
        quickSort(resArr,t,resArr.length-1);
        return resArr;
    }

    public void quickSort(int[] arr,int low,int high){
        if(low < high){
            int i = low,j = high;
            int x = arr[i];
            while(i < j){
                while(i < j&&arr[j] > x)
                    j--;
                if(i < j)
                    arr[i++] = arr[j];
                while(i < j && arr[i] < x)
                    i++;
                if(i<j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);
        }
    }

    /**
     * 声明一个数组 存放arr1中元素个数  index代表元素  值代表个数!!!!!!
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        // 声明一个数组 存放arr1中元素个数  index代表元素  值代表个数!!!!!!
        int[] newArr = new int[1001];
        for(int num : arr1){
            newArr[num]++;
        }
        // 遍历数组2 将arr2有的元素放进结果数组中
        int[] resArr = new int[arr1.length];
        int index = 0;
        for(int num : arr2){
            while(newArr[num]-- >0){
                resArr[index++] =  num;
            }
        }
        // 将arr2不存在的数放入结果数组
        for(int i = 0;i < 1001;i++){
            while(newArr[i]-- >0){
                resArr[index++] =  i;
            }
        }
        return resArr;
    }

}
