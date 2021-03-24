package easy_sort_test;

/**
 * ClassName: Test10
 * date: 2021/3/19 8:58
 *
 * @author JJJJ
 * Description:
 */
public class Test10 {
    /*
    请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G"
     解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
     */


    public String interpret(String command) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < command.length();i++){
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    sb.append("o");
                    i++;
                    continue;
                }
                sb.append("al");
                i += 3;
                continue;
            }
            sb.append("G");
            continue;
        }

        return sb.toString();

    }


}
