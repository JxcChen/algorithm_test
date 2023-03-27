package my_array;

import java.util.Stack;

/**
 * @author: JJJJ
 * @date:2022/8/15 9:29
 * @Description: Desc
 */
public class MyStack<E> {
    /*
    实现一个栈，底层运用数组算法
     */

    // 声明默认最大长度  因为数组存在长度限制
    private final int maxSize = 10;
    // 声明一个底层储存元素的数组
    private E[] arrStack;
    // 声明一个top指针 指向栈顶
    private int top = -1;

    public MyStack(){
        arrStack = (E[]) new Object[maxSize];
    }

    public MyStack(int n){
        // 需要先判断n的大小是否大于0
        if(n <= 0){
            System.out.println("数组长度要大于0");
            System.exit(1);
        }
        arrStack = (E[]) new Object[n];
    }

    /**
     * 入栈
     * @param e 入栈元素
     */
    public void push(E e){
        // 需要先判断是否任由空间
        int length = arrStack.length;
        if(top == length -1){
            // 进行扩容
            E[] newStack = (E[]) new Object[length*2];
            // 将老数据迁移到新数组
            System.arraycopy(arrStack,0,newStack,0,length);
            arrStack = newStack;
        }
        // 进行压栈
        top++;
        arrStack[top] = e;
    }

    /**
     * 出栈
     * @return 栈顶元素
     */
    public E pop(){
        // 先判断是否为空栈
        if(top == -1){
            System.out.println("当前栈为空");
            return null;
        }
        E e = arrStack[top];
        top--;
        return e;
    }

    /**
     * 取栈顶元素
     * @return 栈顶元素
     */
    public E getTop(){
        if(isEmpty()){
            System.out.println("当前栈为空");
            return null;
        }
        return arrStack[top];
    }

    /**
     * 判断是否为空栈
     * @return boolean
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 获取栈的长度
     * @return length
     */
    public int size()
    {
        return top+1;
    }

    /**
     * 遍历栈
     */
    public void nextOrder()
    {
        for(int i=top;i>=0;i--)
            System.out.println(arrStack[i]);
    }

    /**
     * 清空栈
     */
    public void clear()
    {
        top=-1;
    }
}
