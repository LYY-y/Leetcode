import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**面试题62.圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class TheLastNumberLeftInTheCircle {
    //linklist超时, arraylist11.91
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1){
            i = (i + m - 1) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }

    //数学解法 99.88
    public int lastRemaining2(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }
        return ans;
    }

    //优秀解答
    public int lastRemaining3(int n, int m) {
        int dp1 = 1;
        for(int i=2;i<=n;i++){
            int removeNum = m %i;
            //剩下的要留下来的
            dp1 = removeNum+dp1;
            if(dp1 > i){
                dp1 = dp1 -i;
            }
        }
        return dp1-1;
    }
        public static void main(String[] args){
        TheLastNumberLeftInTheCircle t = new TheLastNumberLeftInTheCircle();
        System.out.println("3 "+t.lastRemaining3(5,3));
        System.out.println("2 "+t.lastRemaining3(10,17));

    }
}
