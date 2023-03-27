import java.util.LinkedList;

/**
 * @author: JJJJ
 * @date:2023/2/8 7:47
 * @Description: Desc
 */
public class Test_862 {
    public static void main(String[] args) {
        int res = shortestSubarray(new int[]{1},1);
        System.out.println(res);
    }

    public static int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        // 先声明一个前缀和
        long[] preSum = new long[len + 1];
        for(int i = 1;i < len+1;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        // 声明一个单调队列作为窗口
        MonotonicQueue2 window = new MonotonicQueue2();
        // 进行滑动窗口
        int res = Integer.MAX_VALUE;
        int right = 0, left = 0;
        while(right < len + 1){
            long rSUm = preSum[right++];
            // 增大窗口
            window.push(rSUm);
            // 当找到连续数组大于k是缩小窗口  window.min() 第一个为0
            while(!window.isEmpty() && rSUm - window.min() >= k){
                long lSum = preSum[left];
                window.pop(lSum);
                left++;
                res = Math.min(res,right - left);
            }
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }
}

class MonotonicQueue2{
    LinkedList<Long> minDeque = new LinkedList<>();
    public void push(long ele){
        // 将大于当前元素的全部清除
        while(!minDeque.isEmpty() && ele < minDeque.getLast()){
            minDeque.pollLast();
        }
        minDeque.addLast(ele);
    }

    public void pop(long ele){
        if(ele == minDeque.getFirst()){
            minDeque.pollFirst();
        }
    }

    public long min(){
        return minDeque.getFirst();
    }

    public boolean isEmpty(){
        return minDeque.isEmpty();
    }
}