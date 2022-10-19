import java.util.HashMap;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/8/277:44 上午
 * @Description: 前缀和练习
 */
public class PreSum {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        findMaxLength(nums);
        System.out.println("debug");
    }
    public static int findMaxLength(int[] nums) {
//        int n = nums.length;
//        int[] preSum = new int[n + 1];
//        preSum[0] = 0;
//        // 计算 nums 的前缀和
//        for (int i = 0; i < n; i++) {
//            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
//        }
//        // 前缀和到索引的映射，方便快速查找所需的前缀和
//        HashMap<Integer, Integer> valToIndex = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < preSum.length; i++) {
//            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
//            if (!valToIndex.containsKey(preSum[i])) {
//                valToIndex.put(preSum[i], i);
//            } else {
//                // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
//                int preI = valToIndex.get(preSum[i]);
//                res = Math.max(res, i - valToIndex.get(preSum[i]));
//            }
//            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
//        }
//        return res;
        // 使用前缀和 将0看做-1 则出现0和1的话和就为0
        // 将前缀和索引储存 找到出现0最大索引处
        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for(int i = 0;i<n;i++){
            preSum[i+1] = preSum[i]+ (nums[i] == 0? -1:1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<=n;i++){
            // 如果遍历到不存在的前缀和则进行储存
            if(!map.containsKey(preSum[i])){
                map.put(preSum[i],i);
            }else{
                // 如果出现0,1后 preSum[i]=0 否则会大于0
                res = Math.max(res,i - preSum[i]);
            }
        }
        return res;
    }

}
