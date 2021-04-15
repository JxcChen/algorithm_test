package medium_sort_test;

/**
 * ClassName: Test01
 * date: 2021/3/30 9:43
 *
 * @author JJJJ
 * Description:
 */
public class Test01 {

    /*
        给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     */


    public static void main(String[] args) {
        int[] nums = {1,0};
        sortColors(nums);
        for (int num : nums
             ) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        // 使用系统自带排序
        // Arrays.sort(nums);

        // 使用快速排序
        //quickSort(0,nums.length-1,nums);

        // 使用双指针
        int len = nums.length;
        int index0 = 0,index2=len-1;// index0 为0所在位置 index2为2所在位置
        int temp = 0;
        for(int i = 0;i < len;i++){
            // 当nums[index2] == 2 时index2一直往前移
            while(nums[index2] == 2 && index2 >= 0)
                index2--;
            // 找出值为2的索引进行替换
            if(i < index2 && nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[index2];
                nums[index2--] = temp;
            }

            while(nums[index0] == 0 && index0 < len)
                index0++;
            if(i > index0 && nums[i] == 0){

                temp = nums[i];
                nums[i] = nums[index0];
                nums[index0++] = temp;
            }
        }

    }

    public void sortColors2(int[] nums) {
        // 使用双指针
        int len = nums.length;
        // 通过找到0 和 1 的位置进行交换
        int index0 = 0,index1 = 0,temp = 0;
        for(int i = 0; i < len;i++){
            // 先判断nums[i]是否为1
            if(nums[i] == 1){
                temp = nums[i];
                nums[i] = nums[index1];
                nums[index1++] = temp;
            }else if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[index0];
                nums[index0] = temp;
                if(index0 < index1){
                    // 当index0 < index1 时说明 被替换到nums[i]的数为 1
                    temp = nums[i];
                    nums[i] = nums[index1];
                    nums[index1] = temp;
                }
                index0++;
                index1++;
            }
        }

    }

    public void sortColors3(int[] nums) {

        // 使用单指针
        int len = nums.length;
        int index = 0,temp = 0;
        for(int i = 0;i < len;i++){
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
        for(int i = index;i < len;i++){
            if(nums[i] == 1){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }

    }

    public static void quickSort(int l,int r,int[] nums){
        if(r > l){
            int i = l;
            int j = r;
            int x = nums[l];
            while(i < j){
                // 找到左边比右边大的第一个数
                while(i < j && nums[j] >= x)
                    j--;
                if(i < j)
                    nums[i++] = nums[j];
                while(i < j && nums[i] <= x)
                    i++;
                if(i < j)
                    nums[j--] = nums[i];
            }
            nums[i] = x;
            quickSort(l,i-1,nums);
            quickSort(i+1,r,nums);
        }
    }

}
