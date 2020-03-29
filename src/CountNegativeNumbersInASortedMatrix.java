/**1351.统计有序矩阵中的负数
 *给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回 grid 中 负数 的数目。 */
public class CountNegativeNumbersInASortedMatrix {
    // 100 100
    public int countNegatives(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for (int i = r - 1; i >= 0; i--){
            for (int j = 0; j < c; j++){
                if (grid[i][j] < 0){
                    res += c - j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        CountNegativeNumbersInASortedMatrix c = new CountNegativeNumbersInASortedMatrix();
        System.out.println("8 "+c.countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
        System.out.println("0 "+c.countNegatives(new int[][]{{3,2},{1,0}}));
        System.out.println("3 "+c.countNegatives(new int[][]{{1,-1},{-1,-1}}));
        System.out.println("1 "+c.countNegatives(new int[][]{{-1}}));
    }
}
