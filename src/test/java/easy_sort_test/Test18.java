package easy_sort_test;

import java.util.Arrays;

/**
 * @author: JJJJ
 * @date:2021/12/7 8:57
 * @Description: TODO
 */
public class Test18 {

    /*
        给定两个字符串 s 和 t，它们只包含小写字母。

        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

        请找出在 t 中被添加的字母。
     */

    public static void main(String[] args) {
        String s = "a", t = "aa";
        System.out.println(findTheDifference2(s, t));
    }

    public static char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.toCharArray()[0];
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        int len = sArr.length;
        for(int i = 0;i<len;i++){
            if (sArr[i] != tArr[i])
                return tArr[i];
        }
        return tArr[len];
    }


    public static char findTheDifference2(String s, String t) {
        if(s.length() == 0){
            return t.toCharArray()[0];
        }
        int[] sArr = new int[26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            sArr[c - 'a']++;
        }
        for (int i = 0;i<s.length();i++){
            char c = t.charAt(i);
            sArr[c - 'a']--;
            if(sArr[c - 'a'] < 0)
                return c;
        }
        return t.charAt(t.length()-1);
    }
}
