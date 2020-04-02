/**289.生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class GameOfLife {
    /**引入复合状态
     * 规则 1：如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡。这时候，将细胞值改为 -1，代表这个细胞过去是活的现在死了；

     规则 2：如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活。这时候不改变细胞的值，仍为 1；

     规则 3：如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡。这时候，将细胞的值改为 -1，代表这个细胞过去是活的现在死了。可以看到，因为规则 1 和规则 3 下细胞的起始终止状态是一致的，因此它们的复合状态也一致；

     规则 4：如果死细胞周围正好有三个活细胞，则该位置死细胞复活。这时候，将细胞的值改为 2，代表这个细胞过去是死的现在活了。

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/game-of-life/solution/sheng-ming-you-xi-by-leetcode-solution/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[] step = {0,1,-1};
        for (int row = 0; row < r; row++){
            for (int col = 0; col < c; col++){
                int liveCount = 0;
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (!(step[i] == 0 && step[j] == 0)) {
                            int nr = row + step[i];
                            int nc = col + step[j];
                            if ((nr >= 0 && nr < r) && (nc >= 0 && nc < c) && Math.abs(board[nr][nc]) == 1) {
                                liveCount++;
                            }
                        }
                    }
                }
                if ((board[row][col] == 1) && (liveCount < 2 || liveCount > 3)){
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveCount == 3){
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (board[row][col] > 0){
                    board[row][col] = 1;
                }else {
                    board[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        GameOfLife g = new GameOfLife();
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        g.gameOfLife(board);
    }
}
