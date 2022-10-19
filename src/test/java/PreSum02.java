import java.util.HashMap;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/9/38:55 上午
 * @Description:
 */
public class PreSum02 {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};

        subarraySum(test,3);
        System.out.println("debug");
    }
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        // 记录和为 k 的子数组个数
        int res = 0;

        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            // 如果之前存在值为 need 的前缀和
            // 说明存在以 nums[i-1] 结尾的子数组的和为 k
            int need = preSum[i] - k;
            if (count.containsKey(need)) {
                res += count.get(need);
            }
            // 将当前前缀和存入哈希表
            if (!count.containsKey(preSum[i])) {
                count.put(preSum[i], 1);
            } else {
                count.put(preSum[i], count.get(preSum[i]) + 1);
            }
        }
        return res;
    }

}
