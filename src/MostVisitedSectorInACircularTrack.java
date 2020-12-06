/**1560. 圆形赛道上经过次数最多的扇区
 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。

 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。

 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 * */
import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack {
//    由于马拉松全程只会按照同一个方向跑，中间不论跑了多少圈，对所有扇区的经过次数的贡献都是相同的。因此此题的答案仅与起点和终点相关。
//    从起点沿着逆时针方向走到终点的这部分扇区，就是经过次数最多的扇区。
    //99.88%,58.73%
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start  = rounds[0];
        int end = rounds[rounds.length-1];
        List<Integer> list = new ArrayList<Integer>();
        if (start <= end){
            for (int i=start; i<=end; i++){
                list.add(i);
            }
        }else {
            for (int i = 1; i <= end; i++){
                list.add(i);
            }
            for (int i = start; i <= n; i++){
                list.add(i);
            }
        }
        return list;
    }
}
