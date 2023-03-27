package 数据机构练习题.第三章;

/**
 * @author: JJJJ
 * @date:2022/10/14 8:54
 * @Description: Desc
 */
public class Test3_4 {
    int maxSize = 10;
    int[] arrQueue;
    int front;
    int size;

    public Test3_4(int n){
        arrQueue = new int[n];
        front = 0;
        size = 0;
    }

    public Test3_4(){
        arrQueue = new int[maxSize];
        front = 0;
        size = 0;
    }

    /**
     * 入队
     * @param n 入队元素
     */
    public void offer(int n){
        // 先判断是否存满
        if(size == arrQueue.length){
            // 扩容
            resize(size*2);
        }
        // 找到队尾位置进行插入
        int last = (front+size) % arrQueue.length;
        arrQueue[last] = n;
        size++;
    }

    /**
     * 出队
     */
    public int pull(){
        isEmpty();
        // 在头部出队
        int res = arrQueue[front++];
        size-- ;
        return res;
    }

    /**
     * 判断是否为空
     */
    public void isEmpty(){
        if (size == 0){
            throw new NullPointerException();
        }
    }

    /**
     * 进行扩容
     * @param newCap 扩容后的长度
     */
    private void resize(int newCap) {
        int[] temp = new int[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = arrQueue[(front + i) % arrQueue.length];
        }
        front = 0;
        arrQueue = temp;
    }

    public static void main(String[] args) {
        Test3_4 test3_4 = new Test3_4(2);
        test3_4.offer(1);
        test3_4.offer(2);
        test3_4.offer(3);
        System.out.println(test3_4.pull());
        System.out.println(test3_4.pull());
        System.out.println(test3_4.pull());
        System.out.println(test3_4.pull());

    }
}


