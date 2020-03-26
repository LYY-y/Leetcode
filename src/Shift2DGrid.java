import java.util.ArrayList;
import java.util.List;

/**1260.二维网络迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shift-2d-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Shift2DGrid {
    //96.9 64.34
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[] arr = new int[row * col];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i = k;
        if (k > arr.length){
            i %= arr.length;
        }
        for (int[] r : grid){
            for (int e : r){
                if (i == arr.length){
                    i = 0;
                }
                arr[i++] = e;
            }
        }
        i = 0;
        for (int j = 0; j < row; j++){
            List<Integer> list = new ArrayList<>();
            for (int z = 0; z < col; z++){
                list.add(arr[i++]);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args){
        Shift2DGrid s = new Shift2DGrid();
        System.out.println(s.shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1));
        System.out.println(s.shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}},9));
        System.out.println(s.shiftGrid(new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}},4));
        System.out.println(s.shiftGrid(new int[][]{{1}},100));

    }
}
