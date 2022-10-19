package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/35:05 下午
 * @Description: 单向链表
 */
public class SinglyLinkedList {
    Node head;
    // 插入到结尾
    public void insertTail(int value){
        // 先查看链表是否为空
        if(head == null) {
            insertHead(value);
            return;
        };
        // 先找到尾结点
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        // 声明一个新的元素 并将当前尾结点的next指向该新元素
        current.next = new Node(value);
    }

    // 在头部插入
    public void insertHead(int value){
        Node newNode = new Node(value);
        // 将新元素的next指向原头结点
        newNode.next = head;
        // 将头结点移动到新元素
        head = newNode;
    }

    // 打印
    public void printAll(){
        // 循环进行遍历打印
        Node current = head;
        while (current!=null){
            System.out.print(current.data+"  ");
            current = current.next;
        }
    }
    // 根据值进行查找
    public int findByValue(int value){
        if (head==null)return -1;
        Node current = head;
        while (current != null && current.data != value){
            current = current.next;
        }
        if(current == null){
            return -1;
        }
        return current.data;
    }
    // 删除
    public boolean deleteByValue(int value){
        // 判断是否为空
        if(head == null) return false;
        Node current = head;
        // 储存上一元素
        Node before = null;
        while (current != null && current.data!=value){
            before = current;
            current = current.next;
        }
        if(current == null){
            // 证明没找到对应的node
            return false;
        }
        if (before == null){
            // 如果上一元素为空则证明没进入循环，说明当前元素就是需要被删除的元素
            head = current.next;
        }else{
            // 到这里表示 current就是要被删除的元素
            before.next = current.next;
        }
        return true;
    }

    // 在下一节点进行插入
    public boolean insertAfter(Node node,int value){
        if(node==null)
            return false;
        Node newNode = new Node(value);
        // 将新节点的next指向node的next
        newNode.next = node.next;
        // 将传入节点的next指向新建的节点
        node.next = newNode;
        return true;
    }
    // 在上一节点进行插入
    public boolean insertBefore(Node node,int value){
        if(node==null)
            return false;
        if (head == null || head == node){
            insertHead(value);
        }
        // 储存上一元素
        Node current = head;
        while (current != null && current.next!=node){
            current = current.next;
        }
        if (current == null){
            return false;
        }
        // current 为node的上一节点
        Node newNode= new Node(value);
        newNode.next = node;
        current.next = newNode;
        return true;
    }
    // 声明节点
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
