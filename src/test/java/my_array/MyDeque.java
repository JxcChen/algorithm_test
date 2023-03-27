package my_array;

import java.util.NoSuchElementException;

/**
 * @author: JJJJ
 * @date:2022/8/16 8:39
 * @Description: 双向队列实现
 */
public class MyDeque<E> {
    E[] data;
    final int INIT_LEN=0;
    int first=0,last=0;
    int size = 0;
    public MyDeque(){
        data = (E[]) new Object[INIT_LEN];
    }

    public MyDeque(int len){
        data = (E[]) new Object[len];
    }

    /***** 增 *****/

    public void addFirst(E e){
        // 判断是否需要扩容
        if(size == data.length){
            resize(2 * size);
        }
        // first左移 在将元素插入
        // 判断防越界
        if(first == 0){
            first = data.length-1;
        }else{
            first--;
        }
        data[first] = e;
        size++;
    }

    public void addLast(E e){
        // 判断是否需要扩容
        if(size == data.length){
            resize(2 * size);
        }
        // 将元素插入后 last进行右移   因为这是一个左闭右开的区间
        // 判断防越界
        data[last] = e;
        if(last == data.length-1){
            last = 0;
        }else{
            first--;
        }
        size++;
    }

    /***** 删 *****/
    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        // 判断缩容
        int length = data.length;
        first++;
        E delete = data[first];
        data[first] = null;
        if(size <= length /4){
            resize(length /2);
        }
        // first指针右移
        if (first == length){
            first = 0;
        }

        size--;
        return delete;
    }

    public E removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        // 判断缩容
        if(size <= data.length/4){
            resize(data.length/2);
        }
        // last指针右移
        if (last == 0){
            last = data.length-1;
        }
        last--;
        E delete = data[last];
        data[last] = null;
        size--;
        return delete;
    }

    /***** 查 *****/
    public E getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return data[first];
    }

    public E getLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (last == 0){
            return data[data.length-1];
        }
        return data[last-1];
    }


    /***** 工具函数 *****/

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        //   first-----last
        // ---last    first---

        for (int i = 0; i < size; i++) {
            temp[i] = data[(first + i) % data.length];  // 求余能保证每个index都是在合理的索引内
        }

        first = 0;
        last = size;
        data = temp;
    }
}
