package medium;

import java.util.HashMap;

/**
 * @author: JJJJ
 * @date:2022/7/5 9:20
 * @Description: TODO
 */
public class Test_1 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("tmmzuxt");
    }
    public static int lengthOfLongestSubstring(String s) {
        // 将从左到右的字符一个个存起来
        // 使用双指针遇到重复的就将右侧指针到左侧指针位置的长度存起来
        // 然后比较哪个字符串长度最大
        HashMap<Character,Integer> window = new HashMap<>();
        // 声明双指针
        int left=0,right=0,res = 0;
        while(right < s.length()){
            // 右指针先往右遍历
            char c = s.charAt(right++);
            // 将c存起来
            window.put(c,window.getOrDefault(c,0) + 1);
            // 判断是否出现重复
            while(window.get(c) > 1){
                // 说明出现重复字符
                // 将原本储存的数量清空
                char d = s.charAt(left++);
                window.put(d,window.get(d) - 1);
            }
            // 记录当前最大长度
            res = Math.max(res,right - left);
        }
        return res;
    }
}
