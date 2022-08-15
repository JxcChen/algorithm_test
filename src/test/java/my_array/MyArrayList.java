package my_array;

import java.util.NoSuchElementException;

/**
 * @author: JJJJ
 * @date:2022/8/12 8:20
 * @Description: Desc
 */
public class MyArrayList<E> {
    /*
     * 数组能随机访问元素的原因
     * 1、 第一个元素的地址是知道的
     * 2、 每个元素占用的空间是确定的
     * 3、 数组是紧凑存取的，连续无空隙的
     * 如 ： 想要拿到第三个元素的  假设第一个元素地址为x  每个int类型元素的占用4个字节 => 第三个则是x + (3*4)~x + (4*4)之间
     *
     * 数组的插入和删除：因为数组是紧凑存储的，所以插入或删除后，后面的元素都需要进行移动
     *
     * 底层数组结构无法动态进行扩容和缩容
     */

    // 真正用于储存元素的变量
    private E[] data;
    // 记录当前数组中的元素个数
    private int size;
    // 默认初始的容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCap) {
        this.data = (E[]) new Object[initCap];
        size = 0;
    }

    ;

    /**********新增**********/
    public void add(int index,E ele){
        checkPositionIndex(index);
        // 如果长度不够需要扩容
        if (data.length == size) {
            resize(data.length * 2);
        }
        // 1、 数据迁移  将index往后的元素 迁移到 index+1 ....
        System.arraycopy(data,index,data,index+1,size-1);
        // 在将元素放入index位置
        data[index] = ele;
        size++;
    }

    //在末尾新增
    public void addLast(E e) {
        // 如果长度不够需要扩容
        if (data.length == size) {
            resize(data.length * 2);
        }
        data[size] = e;
        size++;
    }

    /**********删除**********/

    public E remove(int index){
        checkElementIndex(index);
        // 判断是否需要缩容
        if(size < data.length /4){
            resize(data.length/2);
        }
        E delEle = data[index];
        // 1、数据迁移  将index+1及后面的元素 迁移到index
        System.arraycopy(data,index+1,data,index,size-index-1);
        // 2、将最后一个元素置空
        data[size-1] = null;
        size--;
        return delEle;
    }

    public E removeLast(){
        // 判断是否为空
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        // 判断是否需要缩容
        if(size < data.length /4){
            resize(data.length/2);
        }
        E res = data[size - 1];
        data[size - 1] = null; // 必须要将最后一个元素置空 否则无法对其进行回收 可能会导致内存泄露问题
        size--;
        return res;
    }

    /**********查询**********/

    public E get(int index){
        // 先检查索引
        checkElementIndex(index);
        return data[index];
    }

    /**********修改**********/
    public E set(int index,E ele){
        // 先检查索引
        checkElementIndex(index);
        E res = data[index];
        data[index] = ele;
        return res;
    }


    /**********方法区**********/


    private boolean isEmpty() {
        return size==0;
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
        return index>=0 && index < size - 1;
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
        return index>=0 && index < size;
    }

    /**
     * 进行扩容
     * @param newCap 扩容后的长度
     */
    private void resize(int newCap) {
        E[] temp = (E[])new Object[newCap];
        for (int i=0;i < size; i++){
            temp[i] = data[i];
        }
        data = temp;
    }
}
