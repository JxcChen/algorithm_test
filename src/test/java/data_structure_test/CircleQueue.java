package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/33:06 下午
 * @Description: 循环队列
 */
public class CircleQueue {
    // 容量
    int n = 0;
    String[] items;
    // 头结点
    int head = 0;
    // 尾结点
    int tail = 0;

    public CircleQueue(int capacity){
        n = capacity;
        items = new String[capacity];
    }
    /**
     * 入队操作
     */
    public boolean enqueue(String item){
        // 循环队列的最后一格不存储数据  用作判断是否已满
        // 如果tail+1取余 等于head的话说明队列已满
        // 比如head在1的位置  如果tail在0的位置，（0+1）% n = 1 则表示队列已满
        if((tail+1)%n == head) return false;
        // 进行插入
        items[tail] = item;
        tail = (tail+1)%n;
        return true;
    }
    /**
     * 出队
     */
    public String dequeue(){
        if (tail==head) return null;
        String resData = items[head];
        head = (head+1) % n;
        return resData;
    }
}
