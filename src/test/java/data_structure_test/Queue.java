package data_structure_test;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/3/32:12 下午
 * @Description: 普通+优化队列
 */
public class Queue {
    // 声明容量
    int n = 0;
    String[] items;
    // 头结点
    int head;
    // 尾结点
    int tail;
    public Queue(int capacity){
        n = capacity;
        items = new String[n];
    }
    /**
     * 普通队列入队方式
     * @param item 入队元素
     */
    public boolean enqueue(String item){
        // 判断队列是否已满
        if(tail==n) return false;
        items[tail++] = item;
        return true;
    }
    /**
     * 优化队列入队方式
     * @param item 入队元素
     */
    public boolean optimizationEnqueue(String item){
        // 判断是否已满
        // 如果头结点指向队列首位而尾结点指向n则说明队列已满
        if(tail==n){
            if(head==0) return false;
            // 如果头结点不指向队列首位则说明能够进行迁移
            // head是多少 后面的数就得往前进行迁移多少位
            for(int i = head;i<n;i++){
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        // 进行插入操作
        items[tail++] = item;
        return true;
    }
    // 出队
    public String dequeue(){
        // 判断队列是否为空
        if(head == tail) return null;
        // 进行出队操作
        return items[head++];
    }
}
