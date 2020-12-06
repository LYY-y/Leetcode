import java.util.Arrays;

/**976. 三角形的最大周长
 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

 如果不能形成任何面积不为零的三角形，返回 0。



 示例 1：

 输入：[2,1,2]
 输出：5
 示例 2：

 输入：[1,2,1]
 输出：0
 示例 3：

 输入：[3,2,3,4]
 输出：10
 示例 4：

 输入：[3,6,2,3]
 输出：8


 提示：

 3 <= A.length <= 10000
 1 <= A[i] <= 10^6
 * */
public class LargestPerimeterTriangle {
    //24.73%,71.96%
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int right = len-1;
        while (right >= 2){
            int b = A[right-1];
            int c = A[right-2];
            if (A[right] < b+c && A[right] > b-c && b > Math.abs(A[right]-c) && c > Math.abs(A[right]-b)){
                return A[right]+b+c;
            }else {
                right--;
            }
        }
        return 0;
    }

    //90.47%, 71.27%
    public int largestPerimeter2(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for(int i = n - 1;i >= 2;i--) {
            if(A[i-1] +A[i-2] > A[i]) {
                return A[i-1] + A[i] + A[i-2];
            }
        }
        return 0;
    }

    public static void main(String[] args){
        LargestPerimeterTriangle largestPerimeterTriangle = new LargestPerimeterTriangle();
        System.out.println("5 "+largestPerimeterTriangle.largestPerimeter(new int[]{2,1,2}));
        System.out.println("0 "+largestPerimeterTriangle.largestPerimeter(new int[]{1,2,1}));
        System.out.println("10 "+largestPerimeterTriangle.largestPerimeter(new int[]{3,2,3,4}));
        System.out.println("8 "+largestPerimeterTriangle.largestPerimeter(new int[]{3,6,2,3}));
    }
}
