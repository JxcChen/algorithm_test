package 数据机构练习题.第三章;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Stack;

import static java.nio.file.Files.newBufferedReader;

/**
 * @author: JJJJ
 * @date:2022/10/13 9:01
 * @Description: 使用栈实现 十进制转换
 */
public class Conversion10ToOther {
    /*
    算法思路：
        每位的数都是
     */
    public static void conversion(int N,int r){
        Stack<Integer> s = new Stack<>();
        while(N != 0){
            // 将N%r 压入栈内
            s.push(N % r);
            N = N / r;
        }
        // 出栈  会从小位数到大位数顺序取出
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }



    public static void main(String[] args) {
       conversion(10,8);
    }



}
