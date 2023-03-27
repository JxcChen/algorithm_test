/**
 * @author: JJJJ
 * @date:2022/8/18 12:35
 * @Description: Desc
 */
public class Debug {
    public static void main(String[] args) {
        long res = nthUglyNumber(1000000000,2,217983653,336916467);
        System.out.println("-------");
    }
    public static long nthUglyNumber(int n, int a, int b, int c) {
        // 将三个丑数连边拼接后 找出第n个
        long[] ugly = new long[n];
        int pa= 1,pb = 1,pc = 1;
        long headA = a,headB = b,headC = c;
        int p = 0;
        while(p < n){
            // 获取最小的丑数
            long min = Math.min(headA,Math.min(headB,headC));
            ugly[p++] = min;
            if(min == headA){
                headA = (long) a * ++pa;
            }
            if(min == headB){
                headB = (long)b * ++pb;
            }
            if(min == headC){
                headC = (long)c * ++pc;
            }
        }
        return ugly[n-1];
    }

}
