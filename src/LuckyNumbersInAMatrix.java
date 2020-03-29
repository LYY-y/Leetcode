/**1380.矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
import java.util.ArrayList;
import java.util.List;
public class LuckyNumbersInAMatrix {
    //95.86
    public List<Integer> luckyNumbers (int[][] matrix) {
        int r = 0;
        int c = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            boolean isLucky = true;
            r = i;
            int min = matrix[i][0];
            c = 0;
            for (int j = 0; j < matrix[0].length - 1; j++){
                if (min > matrix[i][j + 1]){
                    min = matrix[i][j + 1];
                    c = j + 1;
                }
            }
            for (int k = 0; k < matrix.length; k++){
                if (k == r){
                    continue;
                }
                if (matrix[r][c] < matrix[k][c]){
                    isLucky = false;
                    break;
                }
            }
            if (isLucky){
                res.add(matrix[r][c]);
            }
        }
        return res;
    }

    public static void main(String[] args){
        LuckyNumbersInAMatrix l = new LuckyNumbersInAMatrix();
        System.out.println(l.luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
        System.out.println(l.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
        System.out.println(l.luckyNumbers(new int[][]{{7,8},{1,2}}));

    }
}
