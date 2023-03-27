package my_array;


import java.util.LinkedList;

/**
 * @author: JJJJ
 * @date:2022/10/13 8:14
 * @Description: 使用链表实现队列
 */
public class MyQueue2<E> {
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;
        Node(E val){this.val = val;}
    }

    // 声明首尾占位节点
    private Node<E> head;
    private Node<E> tail;
    // 声明一个遍历储存当前队列长度
    int length;
    public MyQueue2(){
        head = new Node<E>(null);
        tail = new Node<E>(null);
        head.next = tail;
        tail.prev = head;
        length = 0;
    }

    /**
     * 入队
     *
     * @param e 入队元素
     */
    public void enQueue(E e) {
        // 入队是在队尾进行入队
        Node<E> newData = new Node<>(e);
        Node<E> pre = tail.prev;
        pre.next = newData;
        newData.prev = newData;
        newData.next = tail;
        tail.prev = newData;
        length++;
    }

    /* *******  删除 *******  */

    /**
     * 出队
     *
     * @return 被删的队头元素
     */
    public E poll() {
        isEmpty();
        // 从队列头部进行出队
        Node<E> delData = head.next;
        head.next = head.next.next;
        length--;
        return delData.val;
    }

    /* *******  查询 *******  */

    /**
     * 查看队头元素
     *
     * @return 队头元素
     */
    public E peekFirst() {
        isEmpty();
        // 从队列头部进行出队
        return head.next.val;
    }

    /**
     * 获取队尾元素
     *
     * @return 队尾元素
     */
    public E peekLast() {
        isEmpty();
        return tail.prev.val;
    }

    /**
     * 获取队列长度
     *
     * @return 队列长度
     */
    public int size() {
        return length;
    }

    /* ***** 方法 ***** */

    /**
     * 对队列进行遍历
     */
    public void nextOrder() {
        Node<E> cur = head.next;
        while (cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public void isEmpty() {
        if (length == 0)
            throw new NullPointerException();
    }

}
