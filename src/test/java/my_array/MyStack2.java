package my_array;


/**
 * @author: JJJJ
 * @date:2022/8/15 9:29
 * @Description: Desc
 */
public class MyStack2<E> {
    /*
    实现一个栈，底层运用链表
     */

    // 双链表节点
    private static class Node<E> {
        E val;
        MyStack2.Node<E> next;
        MyStack2.Node<E> prev;
        Node(E val){this.val = val;}
    }

    // 声明一个底层储存元素的数组
    private MyLinkedList<E> stack;
    // 声明一个top指针 指向栈顶
    private MyStack2.Node<E> top;
    // 声明一个变量储存栈的长度
    int length;
    public MyStack2(){
        length = 0;
        stack = new MyLinkedList<>();
    }


    /**
     * 入栈
     * @param e 入栈元素
     */
    public void push(E e){
        stack.addLast(e);
    }

    /**
     * 出栈
     * @return 栈顶元素
     */
    public E pop(){
        // 先判断是否为空栈
        stack.isEmpty();
        return stack.removeLast();
    }

    /**
     * 取栈顶元素
     * @return 栈顶元素
     */
    public E getTop(){
        stack.isEmpty();
        return stack.getLast();
    }


    /**
     * 获取栈的长度
     * @return length
     */
    public int size()
    {
        return stack.getSize();
    }

    /**
     * 遍历栈
     */
    public void nextOrder()
    {
        int size = stack.getSize();
        while(size-->0){
            System.out.println(stack.get(size));
        }
    }

    /**
     * 清空栈
     */
    public void clear()
    {
        stack.clear();
    }
}
