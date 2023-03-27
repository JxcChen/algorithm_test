package my_array;

import java.util.NoSuchElementException;

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
    static class Node<E> {
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

    /****** 新增 ******/
    public void addLast(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;
        x.prev = temp;
        x.next = tail;
        temp.next = x;
        tail.prev = x;
        size++;
    }

    public void addFirst(E e){
        // 先声明两个节点
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        // 先将x节点next指向temp  prev指向head
        x.next = temp;
        x.prev = head;
        // 在将head的next节点和temp的prev节点都指向x节点
        head.next = x;
        temp.prev = x;
        size++;
    }

    public void add(int index,E e){
        checkPositionIndex(index);
        Node<E> x = new Node<>(e);
        Node<E> temp = getNode(index);
        Node<E> temp2 = temp.prev;
        x.prev = temp2;
        x.next = temp;
        temp.prev = x;
        temp2.next = x;
        size++;
    }



    /****** 删除 ******/

    public E removeFirst(){
        isEmpty();
        // 去除只需要将前后两个节点的指针都不再指向该元素即可
        Node<E> first = head.next;
        Node<E> second = first.next;
        head.next = second;
        second.prev = head;
        size--;
        return first.val;
    }

    public E removeLast(){
        isEmpty();
        Node<E> first = tail.prev;
        Node<E> second = first.prev;
        second.next = tail;
        tail.prev = second;

        size--;
        return first.val;
    }

    public E remove(int index){
        isEmpty();
        checkElementIndex(index);
        Node<E> removeEle = getNode(index);
        Node<E> next = removeEle.next;
        Node<E> prev = removeEle.prev;
        next.prev = prev;
        prev.next = next;
        size--;
        return removeEle.val;
    }

    public void clear(){
        head.next = tail;
        size = 0;
    }
    /****** 查找 ******/
    public E get(int index){
        checkElementIndex(index);
        Node<E> target = getNode(index);
        return target.val;
    }

    /**
     * 获取最后一个元素值
     * @return last data
     */
    public E getLast(){
        isEmpty();
        Node<E> target = tail.prev;
        return target.val;
    }

    /**
     * 获取链表长度
     * @return size
     */
    public int getSize(){
        return this.size;
    }

    /****** 修改 ******/
    public void set(int index,E e){
        isEmpty();
        checkElementIndex(index);
        getNode(index).val = e;
    }

    /**
     * 判断链表内是否存在元素
     */
    public void isEmpty() {
        if (size==0){
            throw new NullPointerException();
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }


    /**
     * 获取到指定索引位置的node
     * @param index 索引
     */
    private Node<E> getNode(int index) {
        Node<E> temp;
        if (index >(size/2)){
            temp = tail.prev;
            for(int i = size-1; i >= size-index-1; i--){
                temp = temp.prev;
            }
        }else{
            temp = head.next;
            for(int i = 0; i <= index; i++){
                temp = temp.next;
            }
        }

        return temp;
    }
}
