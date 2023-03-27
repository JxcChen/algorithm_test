import java.util.HashMap;

/**
 * @author: JJJJ
 * @date:2022/8/24 9:09
 * @Description: Desc
 */
public class PreSumTest {

    public static void main(String[] args) {
//        int[][] mat = {{1,2,3},{4,5,6},{5,6,7}};
//        int[][] ints = matrixBlockSum(mat, 1);

//        int[] testArr = {9,9,6,0,6,6,9};
//        longestWPI(testArr);

        int[] nums = {23,2,6,4,7};
        System.out.println(checkSubarraySum(nums, 6));
        System.out.println("debug");
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        NumMatrix numMatrix = new NumMatrix(mat);
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左上角的坐标
                int x1 = Math.max(i - k, 0);
                int y1 = Math.max(j - k, 0);
                // 右下角坐标
                int x2 = Math.min(i + k, m - 1);
                int y2 = Math.min(j + k, n - 1);

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
            }
        }
        return res;
    }

    public static int longestWPI(int[] hours) {
        // 题目说了是以8位界限  所以可以设定大于8位1 小于8为-1
        int len = hours.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for(int i = 0;i<len;i++){
            // 根据8为界限储存前缀和
            preSum[i+1] = preSum[i] + (hours[i] > 8 ? 1 : -1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<=len;i++){
            if(!map.containsKey(preSum[i])){
                map.put(preSum[i],i);
            }
            // 判断当前的前缀和是否大于0  大于则表示为优良时间段
            if(preSum[i] > 0){
                // i 为当前的时间段
                res = Math.max(res,i);
            }else{
                // 小于0表示非优良 所以需要往前找到优良的时间段节点
                if (map.containsKey(preSum[i] - 1)) {
                    int j = map.get(preSum[i] - 1);
                    res = Math.max(res, i - j);
                }
            }

        }
        return res;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 计算 nums 的前缀和
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // 前缀和与 k 的余数到索引的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            // 在哈希表中记录余数
            int val = preSum[i] % k;
            // 如果这个余数还没有对应的索引，则记录下来
            if (!valToIndex.containsKey(val)) {
                valToIndex.put(val, i);
            }
            // 如果这个前缀和已经有对应的索引了，则什么都不做
            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
        }
        int res = 0;
        for (int i = 1; i < preSum.length; i++) {
            // 计算 need，使得 (preSum[i] - need) % k == 0
            int need = preSum[i] % k;
            if (valToIndex.containsKey(need)) {
                if (i - valToIndex.get(need) >= 2) {
                    // 这个子数组的长度至少为 2
                    return true;
                }
            }
        }
        return false;
    }

}

class NumMatrix {
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }


}


