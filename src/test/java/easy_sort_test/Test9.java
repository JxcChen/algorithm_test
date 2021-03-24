package easy_sort_test;

/**
 * ClassName: Test9
 * date: 2021/3/18 8:59
 *
 * @author JJJJ
 * Description:
 */
public class Test9 {

    /**
     * 题目:
     *  给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     */


    /**
     *
     * 多出来的部分直接使用subString方法截取剩下的字符串进行添加
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuffer resStr = new StringBuffer();
        int index = 0;
        int len1 = word1.length();
        int len2 = word2.length();

        while(index < len1 && index < len2){
            resStr.append(word1.charAt(index));
            resStr.append(word2.charAt(index++));
        }
        if(index < len1)
            resStr.append(word1.substring(index,len1));
        if(index < len2)
            resStr.append(word2.substring(index,len2));

        return resStr.toString();
    }

    /**
     * 在循环中进行判断索引大小  若索引小于字符长度就一直加
     */
    public String mergeAlternately2(String word1, String word2) {
         StringBuffer resStr = new StringBuffer();
         int index = 0;
         char[] chArr1 = word1.toCharArray();
         char[] chArr2 = word2.toCharArray();

         while(index < chArr1.length || index < chArr2.length){
             if(index < chArr1.length)
                 resStr.append(chArr1[index]);
             if(index < chArr2.length)
                 resStr.append(chArr2[index]);
             index++;
         }

         return resStr.toString();
    }

}
