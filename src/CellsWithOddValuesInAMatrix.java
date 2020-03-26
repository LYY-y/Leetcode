/**1252.奇数值单元格的数目
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class CellsWithOddValuesInAMatrix {
    //84.02 42.49
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        int count = 0;
        for (int i = 0; i < indices.length; i++){
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        for (int r : rows){
            for (int c :cols){
                if (((r+c) & 1) == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        CellsWithOddValuesInAMatrix c = new CellsWithOddValuesInAMatrix();
        System.out.println(c.oddCells(2,3,new int[][]{{0,1},{1,1}}));
        System.out.println(c.oddCells(2,2,new int[][]{{1,1},{0,0}}));

    }
}
