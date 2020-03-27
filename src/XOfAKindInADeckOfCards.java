import java.util.HashMap;
import java.util.Map;

/**914.卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int d : deck) {
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
        }
        int t = map.get(deck[0]);
        for (Integer v : map.values()){
            t = gcd(t, v);
        }
        return t >= 2;
    }

    public int gcd(int x , int y){
        return x == 0 ? y : gcd(y%x,x);
    }

    public static void main(String[] args){
        XOfAKindInADeckOfCards x = new XOfAKindInADeckOfCards();
        System.out.println("T "+x.hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println("F "+x.hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
        System.out.println("F "+x.hasGroupsSizeX(new int[]{1}));
        System.out.println("T "+x.hasGroupsSizeX(new int[]{1,1}));
        System.out.println("T "+x.hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
        System.out.println("F "+x.hasGroupsSizeX(new int[]{0,0,1,1,1,1,2,2,3,4}));
        System.out.println("F "+x.hasGroupsSizeX(new int[]{0,0,0,0,0,0,0,1,2,3,3,3,4,5,6}));
        System.out.println("T "+x.hasGroupsSizeX(new int[]{0,0,0,1,1,1,1,1,1,2,2,2,3,3,3}));
        System.out.println("F "+x.hasGroupsSizeX(new int[]{0,1,1,1,2,2,3,3,4,5}));

    }
}
