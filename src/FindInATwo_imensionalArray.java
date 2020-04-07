/**面试题04.二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class FindInATwo_imensionalArray {
    //从右上角开始遍历100
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int r = 0;
        int c = matrix[0].length - 1;
        if (c < 0){
            return false;
        }
        while (matrix[r][c] != target){
            if (target > matrix[r][c]){
                r++;
                if (r >= matrix.length){
                    return false;
                }
            }else {
                c--;
                if (c < 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        FindInATwo_imensionalArray f = new FindInATwo_imensionalArray();
        System.out.println("T " + f.findNumberIn2DArray(new int[][]{{1, 4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}}, 5));
        System.out.println("F " + f.findNumberIn2DArray(new int[][]{{1, 4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}}, 20));
        System.out.println("F " + f.findNumberIn2DArray(new int[][]{{-5}}, -2));
        System.out.println("T " + f.findNumberIn2DArray(new int[][]{{-5}}, -5));
        System.out.println("F " + f.findNumberIn2DArray(new int[][]{{}}, -5));
        System.out.println("F " + f.findNumberIn2DArray(new int[][]{{-5}}, -10));
        System.out.println("T " + f.findNumberIn2DArray(new int[][]{{-1,3}}, -1));
        System.out.println("F " + f.findNumberIn2DArray(new int[][]{{-1},{-1}}, -2));

    }
}
