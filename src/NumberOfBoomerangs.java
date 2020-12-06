import java.util.HashMap;
import java.util.Map;

/**447. 回旋镖的数量
 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

 示例:

 输入:
 [[0,0],[1,0],[2,0]]

 输出:
 2

 解释:
 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]*/
public class NumberOfBoomerangs {
    //60.93%,44.27%
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int x=0; x<points.length; x++){
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for (int y=0; y<points.length; y++) {
                if (x == y){
                    continue;
                }
                int dis = distance(points[x],points[y]);
                map.put(dis,map.getOrDefault(dis,0)+1);
            }
            for (int val : map.values()){
                if (val >= 2){
                    count += val*(val-1);
                }
            }
        }
        return count;
    }

    public int distance(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }

    public static void main(String[] args){
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
    }
}
