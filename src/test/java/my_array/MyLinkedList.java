package my_array;

/**
 * @author: JJJJ
 * @date:2022/8/12 8:24
 * @Description: Desc
 */
public class MyLinkedList<E> {
    /*
     * 链表的存储是非连续的，是在系统中随机储存的 需要通过next指针找到下一个元素；所以是无法进行随机访问
     */

    // 双链表节点
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;
        Node(E val){this.val = val;}
    }
    // 首部和尾部占位符
    private final Node<E> head,tail;
    // 链表元素数量
    private int size;

    public MyLinkedList(){
        // 只做占位符用  所以直接声明为null
        this.head = new Node<E>(null);
        this.tail = new Node<E>(null);
        head.next = tail;
        tail.next = null;
        this.size = 0;
    }
}
