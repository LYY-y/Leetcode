import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**1337.方阵中战斗力最弱的K行
 * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
 *
 * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class TheKWeakestRowsInAMatrix {
    //100 100
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] temp = new int[n+1][m];
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < m; j++){
                temp[i][j] = -1;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < m; i++){
            int j = 0;
            while (j < n && mat[i][j] == 1){
                j++;
            }
            int a = 0;
            while (a < m && temp[j][a] != -1){
                a++;
            }
            temp[j][a] = i;
        }
        int b = 0;
        for (int i = 0; i < n+1 && b < k; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == -1 || b >= k) {
                    break;
                }
                res[b++] = temp[i][j];
            }

        }
        return res;
    }

    //优秀解答
    public int[] kWeakestRows2(int[][] mat, int k){
        int[] list = new int[mat.length];
        int[] result = new int[k];
        for(int i=0;i<mat.length;i++){
            list[i] = count(mat[i])*1000+i;
        }
        Arrays.sort(list);
        for(int i=0;i<k;i++){
            result[i] = list[i]%1000;
        }
        return result;
    }

    public int count(int[] nums){
        int sum=0;
        for(int n:nums){
            if(n!=1){
                break;
            }
            sum+=n;
        }
        return sum;
    }
    public static void main(String[] args){
        TheKWeakestRowsInAMatrix t = new TheKWeakestRowsInAMatrix();
        System.out.println(t.kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0},
                {1,1,1,1,1}},3));
        System.out.println(t.kWeakestRows(new int[][]{{1,0,0,0},{1,1,1,1}, {1,0,0,0}, {1,0,0,0}},2));
        System.out.println(t.kWeakestRows(new int[][]{{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}},1));
        System.out.println(t.kWeakestRows(new int[][]{{1,0},{1,0},{1,0},{1,1}},4));

    }
}
