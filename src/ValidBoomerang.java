/**1037. 有效的回旋镖
 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。



 示例 1：

 输入：[[1,1],[2,3],[3,2]]
 输出：true
 示例 2：

 输入：[[1,1],[2,2],[3,3]]
 输出：false


 提示：

 points.length == 3
 points[i].length == 2
 0 <= points[i][j] <= 100*/
public class ValidBoomerang {
    //100.00%,100.00%
    public boolean isBoomerang(int[][] points) {
        return ((points[1][1]-points[0][1])*(points[2][0]-points[0][0]))!=((points[2][1]-points[0][1])*(points[1][0]-points[0][0]));
    }

    //鞋带公式 100.00%,100.00%
    public boolean isBoomerang2(int[][] points) {
        return 0.5*Math.abs((points[0][0]*points[1][1]+points[1][0]*points[2][1]+points[2][0]*points[0][1])-(points[1][0]*points[0][1]+points[2][0]*points[1][1]+points[0][0]*points[2][1]))!=0;
    }

    public static void main(String[] args){
        ValidBoomerang validBoomerang=new ValidBoomerang();
        System.out.println(validBoomerang.isBoomerang(new int[][]{{0,0},{2,0},{0,2}}));
        System.out.println(validBoomerang.isBoomerang(new int[][]{{0,0},{0,2},{2,1}}));
    }

}
