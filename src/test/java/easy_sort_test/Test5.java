package easy_sort_test;

/**
 * ClassName: Test5
 * date: 2021/3/12 8:56
 *
 * @author JJJJ
 * Description:
 */
public class Test5 {

    /**
     * 输入：s = "(1+(2*3)+((8)/4))+1"
     * 输出：3
     * 解释：数字 8 在嵌套的 3 层括号中。
     *
     *
     * 输入：s = "(1)+((2))+(((3)))"
     * 输出：3
     */


    public static void main(String[] args) {
        String s = "((((2))))";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {

        char[] charArr = s.toCharArray();
        int left = 0;
        int maxDepth = 0;
        for(char c : charArr){
            if(c == '(')
                left++;
            if(c == ')')
                left--;
            maxDepth = maxDepth > left ? maxDepth : left;
        }
        return maxDepth;
    }
}


