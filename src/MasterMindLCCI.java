import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**面试题16.15. 珠玑妙算
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class MasterMindLCCI {
    public int[] masterMind(String solution, String guess) {
        List<Character> map = new ArrayList<>();
        int right = 0;
        int error = 0;
        for (int i = 0; i < 4; i++){
             map.add(solution.charAt(i));
        }
        for (int j = 0; j < 4; j++){
            char ch = guess.charAt(j);
            if (map.contains(ch)){
                if (map.get(j) == ch){
                    right++;
                    map.set(j,'0');
                }
            }else {
                error++;
            }
        }
        return new int[]{right, 4-right-error};
    }

    public static void main(String[] args){
        MasterMindLCCI m = new MasterMindLCCI();
        System.out.println(m.masterMind("RGBY", "GGRR"));
        System.out.println(m.masterMind("RGRB","BBBY"));

    }
}
