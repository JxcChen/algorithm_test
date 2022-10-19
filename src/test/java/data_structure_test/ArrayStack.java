package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/33:46 下午
 * @Description: 顺序栈
 */
public class ArrayStack {
    private String[] data;
    // 容量
    private int n;
    // 当前数据量
    private int count;
    public ArrayStack(int capacity){
        this.n = capacity;
        count = 0;
        data = new String[n];
    }

    // 入栈
    public boolean push(String value){
        if (n == count)return false;
        data[count++] = value;
        return true;
    }
    // 出栈
    public String pop(){
        if (count==0) return null;
        return data[--count];
    }
}
