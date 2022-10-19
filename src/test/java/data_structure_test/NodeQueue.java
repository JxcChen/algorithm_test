package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/32:40 下午
 * @Description: 链式队列
 */
public class NodeQueue {
    Node head = null;
    Node tail = null;
    // 入队
    public void enqueue(String item){
        // 判断是否为空
        if (tail==null){
            // 如果为空的话就新增一个节点
            Node newNode = new Node(item);
            head = newNode;
            tail = newNode;
        }else{
            // 如果不为空 先将当前节点的next指针指向一个新的节点
            tail.next = new Node(item);
            // 再将尾结点 移动到最新的节点上
            tail = tail.next;
        }
    }
    // 出队
    public String dequeue(){
        // 判断是否为空
        if (head == null) return null;
        // 获取头结点的值
        String resData = head.data;
        // 将头结点移动到 头结点的下一个元素
        head = head.next;
        // 返回数据
        return resData;
    }

    // 声明节点
    public static class Node{
        // 节点储存当前的数据及指向下一节点的指针
        String data;
        Node next = null;
        public Node(String item){
            data = item;
        }
    }
}
