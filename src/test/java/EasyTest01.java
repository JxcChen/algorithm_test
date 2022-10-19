import java.util.Arrays;

/**
 * @author JJJJ
 * @Title:
 * @date 2022/10/198:28 上午
 * @Description:
 */
public class EasyTest01 {

    public static void main(String[] args) {
        int[] students = {1,1,1,1,2,0,0};
        int[] sand = {0,1,0,1};
        int res = countStudents(students,sand);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int[] need = new int[2];
        for(int stu : students){
            need[stu]++;
        }
        for(int sandwiche : sandwiches){
            if(need[sandwiche] != 0){
                need[sandwiche]--;
            }else
                break;
        }
        return need[0]+need[1];
    }
}
