package easy_sort_test;

/**
 * ClassName: Test12
 * date: 2021/3/22 9:49
 *
 * @author JJJJ
 * Description:
 */
public class Test12 {
    /*
    如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
    如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
    返回在比赛中进行的配对次数，直到决出获胜队伍为止。
     */

    /**
     * 使用递归
     */

    public int numberOfMatches(int n) {
        int res = 0;
        return getNum(n,res);
    }

    public int getNum(int n,int res){
        if(n % 2 == 1 && n != 1)
            res = getNum(n / 2 + 1,res)+(n / 2);
        else if(n / 2 != 0)
            res = getNum(n/2,res)+(n / 2);
        return res;
    }

}
