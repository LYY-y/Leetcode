/**1572. 矩阵对角线元素的和
 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。

 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。



 示例  1：



 输入：mat = [[1,2,3],
 [4,5,6],
 [7,8,9]]
 输出：25
 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 请注意，元素 mat[1][1] = 5 只会被计算一次。
 示例  2：

 输入：mat = [[1,1,1,1],
 [1,1,1,1],
 [1,1,1,1],
 [1,1,1,1]]
 输出：8
 示例 3：

 输入：mat = [[5]]
 输出：5


 提示：

 n == mat.length == mat[i].length
 1 <= n <= 100
 1 <= mat[i][j] <= 100
 * */
public class MatrixDiagonalSum {
    //12.79%, 67.95%
    public int diagonalSum(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int sum = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (i == j || i + j == r-1 ){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public int diagonalSum2(int[][] mat) {
        int sum = 0;
        for(int i=0; i<mat.length; i++){
            int tailIndex = mat.length - 1 - i;
            if(i != tailIndex){
                sum += mat[i][i] + mat[tailIndex][i];
            }else{
                sum += mat[i][i];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        MatrixDiagonalSum matrixDiagonalSum = new MatrixDiagonalSum();
        System.out.println("25 " +matrixDiagonalSum.diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println("8 " +matrixDiagonalSum.diagonalSum(new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1},{1,1,1,1}}));
    }
}
