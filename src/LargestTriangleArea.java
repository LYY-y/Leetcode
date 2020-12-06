/**812. 最大三角形面积
 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。

 示例:
 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 输出: 2
 解释:
 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。


 注意:

 3 <= points.length <= 50.
 不存在重复的点。
 -50 <= points[i][j] <= 50.
 结果误差值在 10^-6 以内都认为是正确答案。*/
public class LargestTriangleArea {
    //87.74%,42.29%
    public double largestTriangleArea(int[][] points) {
        double maxS = 0;
        for (int i=0; i<points.length-2; i++){
            for (int j=i+1; j<points.length-1; j++){
                for (int k=j+1; k<points.length; k++) {
                    double S = getArea(points[i],points[j],points[k]);
                    maxS = Math.max(maxS, S);
                }
            }
        }
        return maxS;
    }

    //鞋带公式
    public double getArea(int[] A, int[] B, int[] C){
        return 0.5*Math.abs(A[0]*B[1]+B[0]*C[1]+C[0]*A[1]-A[1]*B[0]-B[1]*C[0]-C[1]*A[0]);
    }

    public boolean isTriangle(double a, double b, double c){
        if (a+b<c||a+c<b||b+c<a){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        LargestTriangleArea largestTriangleArea=new LargestTriangleArea();
//        System.out.println(largestTriangleArea.largestTriangleArea(new int[][]{{-32,5},{-14,40},{-19,-30},{-46,-38},
//                {5,-11},{-30,-20},{-3,-21},{37,14},{-50,-6},{31,-31},{5,47},{-50,28},{16,-40},{34,24},{5,13},{-6,-23},
//                {-15,-15},{30,-46},{2,20},{-15,2},{-3,-25},{6,-37},{-14,-45},{50,-35},{-12,-45},{25,8},{37,25},{38,25},
//                {-25,-35},{28,-21},{-11,27},{-26,11},{34,35},{-18,43},{48,43},{2,-41},{-23,20},{-1,-6},{45,7},{5,-20},{33,-2},
//                {45,-37},{-44,14},{-14,-23},{42,-3},{7,-8},{-4,4},{49,-3},{23,15},{-50,-47}}));
//        System.out.println(largestTriangleArea.largestTriangleArea(new int[][]{{9,0},{0,2},{3,1},{10,8}}));
        System.out.println(largestTriangleArea.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
    }
}
