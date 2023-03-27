import java.util.LinkedList;

/**
 * @author: JJJJ
 * @date:2023/2/7 8:50
 * @Description: Desc
 */
public class Test_1438 {
    public static void main(String[] args) {
        int res = longestSubarray(new int[]{8,2,4,7},4);
        System.out.println(res);
    }

    public static int longestSubarray(int[] nums, int limit) {
        // 需要借助单调队列 查看连续的绝对差中最大值是否超过limit
        int res = 0;
        int left = 0,right = 0;
        MonotonicQueue mq = new MonotonicQueue();
        while(right < nums.length){
            // 扩大窗口
            int cur = nums[right];
            right++;
            mq.push(cur);
            while(mq.max() - mq.min() > limit){
                // 缩小窗口
                int leftNum = nums[left++];
                mq.pop(leftNum);
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}

class MonotonicQueue{
    LinkedList<Integer> maxDeque = new LinkedList<>();
    LinkedList<Integer> minDeque = new LinkedList<>();
    public void push(int ele){
        // 把小于当前元素的节点全部删除
        while(!maxDeque.isEmpty() && ele > maxDeque.getLast()){
            maxDeque.pollLast();
        }
        maxDeque.addLast(ele);

        // 把大于当前元素的节点全部删除
        while(!minDeque.isEmpty() && ele < minDeque.getLast()){
            maxDeque.pollLast();
        }
        minDeque.addLast(ele);
    }

    public void pop(int ele){
        if(!maxDeque.isEmpty() && maxDeque.getFirst().equals(ele)){
            maxDeque.pollFirst();
        }
        if(!minDeque.isEmpty() && minDeque.getFirst().equals(ele)){
            minDeque.pollFirst();
        }
    }

    public int max(){
        return maxDeque.getFirst();
    }

    public int min(){
        return minDeque.getFirst();
    }
}
