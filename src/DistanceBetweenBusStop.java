/**1184.公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distance-between-bus-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class DistanceBetweenBusStop {
    //超时
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis1 = 0;
        int dis2 = 0;
        int n = distance.length;
        for (int i = start; i != destination; i++){
            if (i == n){
                i = 0;
            }
            dis1 += distance[i];
        }
        for (int j = start; j != destination;){
            if (j == 0){
                j = n - 1;
            }else {
                j--;
            }
            dis2 += distance[j];
        }
        return Math.min(dis1, dis2);
    }

    //100 63.92
    public int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        int l = start;
        int r = start;
        int disL = 0;
        int disR = 0;
        int n = distance.length;
        while (l != destination || r != destination){
            if (l == 0){
                l = n;
            }
            if (r == n) {
                r = 0;
            }
            if (l != destination) {
                disL += distance[--l];
            }
            if (r != destination) {
                disR += distance[r++];
            }
        }
        return Math.min(disL, disR);
    }

    //遍历一次求出环形总距离，两站之间的一个半环距离，总站距离减去半环距离为另一个半环距离，返回两个半环距离较小的即可。
    public int distanceBetweenBusStops3(int[] distance, int start, int destination) {
        int sum = 0;
        int dis = 0;
        int n = distance.length;
        for (int i = 0; i < n; i++){
            sum += distance[i];
            if(i>=Math.min(start,destination)&&i<Math.max(start,destination)){
                dis+=distance[i];
            }
        }
        return Math.min(dis, sum-dis);
    }

        public static void main(String[] args){
        DistanceBetweenBusStop betweenBusStop = new DistanceBetweenBusStop();
        System.out.println("1  "+betweenBusStop.distanceBetweenBusStops3(new int[]{1,2,3,4},0,1));
        System.out.println("3  "+betweenBusStop.distanceBetweenBusStops3(new int[]{1,2,3,4},0,2));
        System.out.println("4  "+betweenBusStop.distanceBetweenBusStops3(new int[]{1,2,3,4},0,3));
        System.out.println("17  "+betweenBusStop.distanceBetweenBusStops3(new int[]{7,10,1,12,11,14,5,0},7,2));
        System.out.println("28  "+betweenBusStop.distanceBetweenBusStops3(new int[]{3,6,7,2,9,10,7,16,11},6,2));
        System.out.println("25  "+betweenBusStop.distanceBetweenBusStops3(new int[]{8,11,6,7,10,11,2},0,3));

    }
}
