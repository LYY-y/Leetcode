/**面试题29.顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。*/
public class PrintMatrixClockwise {
    public int[] spiralOrder(int[][] matrix) {
        int r = matrix.length;
        if (r == 0){
            return new int[]{};
        }
        int c = matrix[0].length;
        int[] res = new int[r*c];
        int i = 0;
        int j = 0;
        int k = 0;
        int temp = 0;
        while (k < res.length){
            while (k < res.length && j < c - temp){
                res[k++] = matrix[i][j++];
            }
            j--;
            i++;
            while (k < res.length && i < r - temp){
                res[k++] = matrix[i++][j];
            }
            i--;
            j--;
            while (k < res.length && j >= temp){
                res[k++] = matrix[i][j--];
            }
            j++;
            i--;
            while (k < res.length && i >= temp + 1){
                res[k++] = matrix[i--][j];
            }
            temp++;
            i = temp;
            j = temp;
        }
        return res;
    }
//优秀解答，定矩阵的“左、上、右、下”四个边界，模拟以上矩阵遍历顺序。
    public int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }

    public static void main(String[] args){
        PrintMatrixClockwise p = new PrintMatrixClockwise();
        System.out.println(p.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(p.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(p.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
    }
}
