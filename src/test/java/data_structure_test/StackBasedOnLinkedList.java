package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/33:55 下午
 * @Description: 链式栈
 */
public class StackBasedOnLinkedList {
    Node head = null;
    public void push(int value){
        Node newNode = new Node(value);
        if (head != null) {
            // 如果栈中不为空的话 将next指向当前元素
            newNode.next = head;
        }
        // 头结点指向最新元素
        head = newNode;
    }

    public int pop(){
        // 判断是否为空
        if(head == null) return -1;
        int resData = head.data;
        // head移动到上一位置
        head = head.next;
        return resData;
    }


    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
