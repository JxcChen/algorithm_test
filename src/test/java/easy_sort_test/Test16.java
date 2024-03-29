package easy_sort_test;

/**
 * @author JJJJ
 * @Title: Test16
 * @date 2021/8/31下午10:45
 * @Description: sortTest
 */
public class Test16 {
    /*
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

    假设环境不允许存储 64 位整数（有符号或无符号）。
     */
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    // 获取最后一位数 放在最前面依次进行
    public static int reverse(int x) {
        long result = 0;
        while(x / 10 != 0 || x % 10 != 0){
            int lastNum = x % 10;
            result = result * 10 + lastNum;
            x /= 10;
        }
        if(result < Math.pow(-2,31) || result > (Math.pow(2,31)-1))
            return 0;
        return (int)result;
    }

}
