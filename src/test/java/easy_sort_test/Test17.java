package easy_sort_test;

import java.util.Arrays;
import java.util.EventListener;

/**
 * @author: JJJJ
 * @date:2021/11/23 8:26
 * @Description: TODO
 */
public class Test17 {


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     */

    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "flght";
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        String longestCommonPrefix = "";
        String currentString = "";
        for(int j= 0;j < strs[0].length();j++){
            for (int i = 0; i < strs.length; i++) {
                try {
                    if (i == 0){
                        currentString = strs[i].substring(0,j+1);
                    }else if (i != strs.length-1){
                        if(!strs[i].substring(0, j + 1).equals(currentString)) {
                            return longestCommonPrefix.toString();
                        }

                    }else {
                        if(strs[i].substring(0, j + 1).equals(currentString))
                            longestCommonPrefix = currentString;
                        else
                            return longestCommonPrefix;
                    }
                } catch (Exception e) {
                    return longestCommonPrefix;
                }
            }

        }

        return longestCommonPrefix;
    }
}
