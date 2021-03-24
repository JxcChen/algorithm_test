package easy_sort_test;

import java.util.Arrays;

public class Test7 {

    /**
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     *
     * 如果不能形成任何面积不为零的三角形，返回 0
     */
    public static void main(String[] args) {
        int[] arr = {3,6,2,3};
        System.out.println(largestPerimeter(arr));
    }
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length-2 ; i > 0;i--){
            if(A[i]+A[i-1]>A[i+1])
                return A[i] + A[i-1] +A[i+1];
        }
        return 0;
    }

}
