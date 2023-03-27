package my_array;

/**
 * @author: JJJJ
 * @date:2022/10/10 12:18
 * @Description: 单向链表的实现
 */
public class MyLinkList<E> {
    // 单向链表节点
    private static class Node<E> {
        E val;
        Node<E> next;
        Node(E val){this.val = val;}
    }
    // 首部占位符
    private final MyLinkList.Node<E> head;
    // 链表元素数量
    private int size;

    public MyLinkList(){
        // 只做占位符用  所以直接声明为null
        this.head = new MyLinkList.Node<E>(null);
        head.next = null;
        this.size = 0;
    }

    /****** 新增 ******/

    public boolean addFirst(E e){
        // 先声明两个节点
        MyLinkList.Node<E> x = new MyLinkList.Node<E>(e);
        MyLinkList.Node<E> temp = head.next;
        // 先将x节点next指向temp  prev指向head
        x.next = temp;
        // 在将head的next节点和temp的prev节点都指向x节点
        head.next = x;
        size++;
        return true;
    }

    public boolean add(E e,int index){
        if (index==0) return addFirst(e);
        checkPositionIndex(index);
        // 先获取到对应索引位置前的节点
        MyLinkList.Node<E> cur = getNode(index);
        // 进行插入
        MyLinkList.Node<E> newData = new Node<E>(e);
        MyLinkList.Node<E> temp = cur.next;
        cur.next = newData;
        newData.next = temp;
        size++;
        return true;
    }

    /****** 删除 ******/

    public E removeFirst(){
        isEmpty();
        // 去除只需要将前后两个节点的指针都不再指向该元素即可
        MyLinkList.Node<E> first = head.next;
        head.next = first.next;  // 没有节点指向first就相当于将first删除
        size--;
        return first.val;
    }


    public E remove(int index){
        isEmpty();
        checkElementIndex(index);
        MyLinkList.Node<E> before = getNode(index);
        MyLinkList.Node<E> removeEle = before.next;
        before.next = removeEle.next;
        size--;
        return removeEle.val;
    }

    /****** 查找 ******/
    public E get(int index){
        checkElementIndex(index);
        MyLinkList.Node<E> target = getNode(index).next;
        return target.val;
    }

    /****** 修改 ******/
    public void set(int index,E e){
        isEmpty();
        checkElementIndex(index);
        getNode(index).next.val = e;
    }

    /**
     * 判断链表内是否存在元素
     */
    private void isEmpty() {
        if (size==0){
            throw new NullPointerException();
        }
    }

    /**
     * 查看当前索引是否越界
     * @param index 查询索引
     */
    private void checkElementIndex(int index){
        if(!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index： " + index+ " Size: "+ size);
        }
    }

    private boolean isElementIndex(int index) {
        return index>=0 && index < size;
    }

    /**
     * 查看插入索引是否越界  插入索引 0 ~ size
     * @param index 插入索引
     */
    private void checkPositionIndex(int index){
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index： " + index+ " Size: "+ size);
    }

    private boolean isPositionIndex(int index) {
        return index>=0 && index <= size;
    }



    /**
     * 获取到指定索引前一位置的node
     * @param index 索引
     */
    private MyLinkList.Node<E> getNode(int index) {
        MyLinkList.Node<E> temp;
        temp = head.next;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        return temp;
    }

    private void nextOrder(){
        Node<E> node = head.next;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static void main(String[] args) {
        MyLinkList<Integer> L=new MyLinkList<Integer>();
        int i;
        int[] a ={23,56,12,49,35};
        for(i=0;i<a.length;i++)
            L.add(a[i], i);   //将数组中各元素插入到单链表中
        System.out.println("单链表中的数据元素为：");
        L.nextOrder();
        L.add(30, 3);
        System.out.println("执行插入操作后单链表中的数据元素为：");
        L.nextOrder();
        L.remove(4);
        System.out.println("执行删除操作后单链表中的数据元素为：");
        L.nextOrder();
        i=L.get(4);        //在单链表L中查找元素12的位序
        System.out.println("元素12在单链表中的位序为:"+i);
    }

}
