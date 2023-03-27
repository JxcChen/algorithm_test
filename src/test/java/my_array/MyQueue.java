package my_array;

/**
 * @author: JJJJ
 * @date:2022/8/15 9:29
 * @Description: 使用数组实现队列
 */
public class MyQueue<E> {

    // 声明两个指针 一个指向头部 一个指向尾部
    private int top, last;
    // 声明一个数组 储存元素
    private E[] queue;
    // 声明一个默认初始长度
    private final int maxSize = 10;
    // 记录当前队列长度
    private int size;

    // 初始化
    public MyQueue() {
        queue = (E[]) new Object[maxSize];
        top = 0;
        last = 0;
        size = 0;
    }

    public MyQueue(int n) {
        queue = (E[]) new Object[n];
        top = 0;
        last = 0;
        size = 0;
    }
    /* *******  新增 *******  */

    /**
     * 入队
     *
     * @param e 入队元素
     */
    public void enQueue(E e) {
        // 判断队列是否已经满了
        if (isFull()) {
            // 进行扩容
            resize(queue.length);
        }
        // 进行入队
        queue[last++] = e;
        // 判断尾结点是否到了队列尾端 到达尾端则回到开头位置
        if (last == queue.length - 1) last = 0;
        size++;
    }

    /* *******  删除 *******  */

    /**
     * 出队
     *
     * @return 被删的队头元素
     */
    public E poll() {
        isEmpty();
        E res = queue[top];
        queue[top] = null;
        top++;
        if (top == queue.length - 1) top = 0;
        size--;
        return res;
    }

    /* *******  查询 *******  */

    /**
     * 查看队头元素
     *
     * @return 队头元素
     */
    public E peekFirst() {
        isEmpty();
        return queue[top];
    }

    /**
     * 获取队尾元素
     *
     * @return 队尾元素
     */
    public E peekLast() {
        isEmpty();
        if (last == 0) return queue[queue.length - 1];
        return queue[last - 1];
    }

    /**
     * 获取队列长度
     *
     * @return 队列长度
     */
    public int size() {
        return size;
    }

    /* ***** 方法 ***** */

    /**
     * 对队列进行遍历
     */
    public void nextOrder() {
        for (int i = 0; i < size; i++) {
            int index = (top + i) % queue.length;
            System.out.println(queue[index]);
        }
    }

    public void isEmpty() {
        if (size == 0)
            throw new NullPointerException();
    }

    public boolean isFull() {
        return size == queue.length - 1;
    }

    /**
     * 扩容
     *
     * @param newCap 队列的长度
     */
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        for (int i = 0; i < size; i++) {
            temp[i] = queue[(top + i) % queue.length];
        }
        top = 0;
        last = size;
        queue = temp;
    }
}
