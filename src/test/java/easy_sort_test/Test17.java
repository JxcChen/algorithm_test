package easy_sort_test;

/**
 * @author JJJJ
 * @Title: Test17
 * @date 2021/8/31下午11:03
 * @Description: easySort
 */
public class Test17 {
    /*
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reverseInt = 0;
        // 翻转一般即可判断出是否为回文数
        while(x > reverseInt){
            int lastNum = x % 10;
            reverseInt = reverseInt * 10 +lastNum;
            x /= 10;
        }
        return reverseInt == x || reverseInt/10 ==x;
    }
}
