package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/38:26 上午
 * @Description: 数组练习
 */
public class ArrayTest {
    // 存储数据
    public int[] data;
    // 当前存储的个数
    private int count;
    // 容量
    private int n;

    public ArrayTest(int capacity){
        n = capacity;
        count = 0;
        // new int[capacity]分配到堆空间
        data = new int[capacity];
    }

    public boolean insert(int index,int value){
        // 判断数组是否已满
        if(count == n){
            return false;
        }
        // 是否越界
        // 如果大于count就证明出现不连续的情况  数组必须时前后连续的 不能存在间隔
        if(index<0 || index > count){
            return false;
        }
        for(int i = index;i<count;i++){
            data[i+1] = data[i];
        }
        data[index] = value;
        count += 1;
        return true;
    }
    public int find(int index){
        if(index < 0 || index > n){
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }
    public Boolean delete(int index){
        if(index < 0 || index > n-1){
            throw new IndexOutOfBoundsException();
        }
        for(int i = index;i<count-1;i++){
            data[i] = data[i+1];
        }
        data[count-1] = 0;
        count -= 1;
        return true;
    }
    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest(5);
        arrayTest.insert(0,1);
        arrayTest.insert(0,2);
        arrayTest.insert(1,2);
        arrayTest.insert(2,3);
        arrayTest.insert(3,4);
        arrayTest.insert(4,5);
        System.out.println(arrayTest.find(1));
        arrayTest.delete(0);
        arrayTest.delete(4);
    }
}
