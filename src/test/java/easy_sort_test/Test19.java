package easy_sort_test;

/**
 * @author: JJJJ
 * @date:2022/10/26 10:28
 * @Description: Desc
 */
public class Test19 {
    public static void main(String[] args) {
        int res = mySqrt(2147395599);
        System.out.println("debug");
    }

    public static int mySqrt(int x) {
        int left = 0, right = x;
        int res = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long cur = (long) mid * mid;
            if (cur == x) return mid;
            else if (cur < x) {
                res = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return res;
    }
}
