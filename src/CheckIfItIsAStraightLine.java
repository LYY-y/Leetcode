/**1232.缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class CheckIfItIsAStraightLine {
    //100 87.6
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length - 1; i++){
            if ((coordinates[1][1]-coordinates[0][1])*(coordinates[i][0]-coordinates[0][0]) != (coordinates[i][1]-coordinates[0][1])*(coordinates[1][0]-coordinates[0][0])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        CheckIfItIsAStraightLine c = new CheckIfItIsAStraightLine();
        System.out.println(c.checkStraightLine(new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}}));
    }
}
