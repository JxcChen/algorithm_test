package sort_test;

/**
 * ClassName: Test4
 * date: 2021/3/11 8:52
 *
 * @author JJJJ
 * Description:
 */
public class Test4 {


   /*
        给你一个字符串 s ，请你根据下面的算法重新构造字符串：
        从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
        从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
        重复步骤 2 ，直到你没法从 s 中选择字符。
        从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
        从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
        重复步骤 5 ，直到你没法从 s 中选择字符。
        重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
        在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
        请你返回将 s 中字符重新排序后的 结果字符串 。
    */

    public static void main(String[] args) {
        int i = 'c' - 'a';
        char c = 'a' +2;
        String s = "";

        System.out.println(c);
    }

    public static String sortString(String s) {
        int[] bucket = new int[26];
        char[] charArr = s.toCharArray();
        char[] resArr = new char[s.length()];
        int index = 0;
        // 将字符全部撞到桶里
        for(char c : charArr){
            bucket[c - 'a']++;
        }

        // 遍历字符串
        while(index < s.length()){
            // 从做左到右在桶里获取元素 并加到结果字符串后面
            for(int i = 0;i < bucket.length;i++){
                if(bucket[i] != 0){
                    resArr[index++] = (char)('a' + i);
                    bucket[i]--;
                }
            }
            // 从做右到左在桶里获取元素 并加到结果字符串后面
            for(int i = 25;i >= 0;i--){
                if(bucket[i] != 0){
                    resArr[index++] = (char)('a' + i);
                    bucket[i]--;
                }
            }
        }

        return new String(resArr);
    }

    /**
     * 使用递归方法进行
     * @param charArr 原数组
     * @param bucket 桶
     * @param resArr 结果数组
     * @param index 索引
     */
    public void getResult(char[] charArr,int[] bucket,char[] resArr,int index){

        for(int i = 0;i < bucket.length;i++){
            if(bucket[i] != 0){
                resArr[index++] = (char)('a' + i);
                bucket[i]--;
            }
        }
        for(int i = 25;i >= 0;i--){
            if(bucket[i] != 0){
                resArr[index++] = (char)('a' + i);
                bucket[i]--;
            }
        }
        if(index < charArr.length)
            getResult(charArr,bucket,resArr,index);
    }
}
