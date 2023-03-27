package 数据机构练习题.第三章;

/**
 * @author: JJJJ
 * @date:2022/10/14 12:30
 * @Description: 实现两个栈公用储存空间
 */
public class Test3_5_1 {
    int[] arrStack;
    int maxSize = 10;
    int top1, top2;

    public Test3_5_1(int n){
        if (n == 0) {
            n = maxSize;
        }
        arrStack = new int[n];
        top1 = -1;
        top2 = n;
    }

    public Test3_5_1() {
        arrStack = new int[maxSize];
        top1 = 0;
        top2 = maxSize - 1;
    }

    /**
     * 压栈
     */
    public void push(int stackNum, int n) {
        // 判断是否已经满了
        if (isFull()) {
            resize(arrStack.length * 2);
        }
        if (stackNum == 1) {
            arrStack[++top1] = n;
        } else {
            arrStack[--top2] = n;
        }
    }

    /**
     * 弹栈
     *
     * @return int
     */
    public int pop(int stackNum) {
        int res;
        if (stackNum == 1) {
            // 判空
            isEmpty(1);
            res = arrStack[top1];
            arrStack[top1--] = 0;
        } else {
            isEmpty(2);
            res = arrStack[top2];
            arrStack[top2--] = 0;
        }
        return res;
    }

    public void clear(int stackNum){
        if (stackNum == 1) top1 = -1;
        else top2 = arrStack.length;
    }

    public boolean isFull() {
        return top1 + 1 == top2;
    }

    public void isEmpty(int stackNum) {
        if (stackNum == 1) {
            if (top1 == -1)
                throw new NullPointerException();
        } else {
            if (top2 == arrStack.length)
                throw new NullPointerException();
        }
    }

    public void resize(int newCap) {
        // 扩容
        // 因为 空间是栈共享 左右两次为栈的头部 所以扩容的空间应该插入到中间
        int[] temp = new int[newCap];
        // 将两个栈的元素搬到新空间中
        System.arraycopy(arrStack, 0, temp, 0, top1 + 1);
        int stack2Len = arrStack.length - top2;
        System.arraycopy(arrStack, top2, temp, newCap - stack2Len, stack2Len);
        top2 = newCap - stack2Len;
        arrStack = temp;
    }

    public static void main(String[] args){
        Test3_5_1 stack = new Test3_5_1(5);
        stack.push(1,1);
        stack.push(2,2);
        stack.push(2,3);
        stack.push(1,5);
        stack.push(1,5);
        stack.push(1,5);
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(2));

    }
}
