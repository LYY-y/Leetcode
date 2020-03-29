import java.util.ArrayDeque;
import java.util.Queue;

/**1162.地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class AsFarFromLandAsPossible {
    //图的BFS
    public int maxDistance(int[][] grid) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        //先把所有陆地都入队
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //从各个陆地开始，一圈一圈遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                //直接修改了原数组，因此就不需要额外的数组来标志是否访问
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        if (point == null || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args){
        AsFarFromLandAsPossible a = new AsFarFromLandAsPossible();
        System.out.println(a.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }
}
