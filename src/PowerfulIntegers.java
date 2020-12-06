/**970. 强整数
 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。

 返回值小于或等于 bound 的所有强整数组成的列表。

 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。



 示例 1：

 输入：x = 2, y = 3, bound = 10
 输出：[2,3,4,5,7,9,10]
 解释：
 2 = 2^0 + 3^0
 3 = 2^1 + 3^0
 4 = 2^0 + 3^1
 5 = 2^1 + 3^1
 7 = 2^2 + 3^1
 9 = 2^3 + 3^0
 10 = 2^0 + 3^2
 示例 2：

 输入：x = 3, y = 5, bound = 15
 输出：[2,4,6,8,10,14]


 提示：

 1 <= x <= 100
 1 <= y <= 100
 0 <= bound <= 10^6*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    //100.00%，42.99%
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<Integer>();
        int res = 0;
        for (int i=0; i<20 && Math.pow(x, i) <= bound;i++){
            for (int j=0;j<20 && Math.pow(x, j) <= bound;j++){
                res = (int) (Math.pow(x,i)+Math.pow(y,j));
                if (res > bound){
                    break;
                }
                if (!list.contains(res)) {
                    list.add(res);
                }
            }

        }
        return list;
    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        int iMax = x == 1 ? 0 : (int)(Math.log(bound-1) / Math.log(x));
        int jMax = y == 1 ? 0 : (int)(Math.log(bound-1) / Math.log(y));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= iMax; i++) {
            for (int j = 0; j <= jMax; j++) {
                if (Math.pow(x,i) + Math.pow(y,j) <= bound) {
                    set.add((int)(Math.pow(x,i) + Math.pow(y,j)));
                } else break;
            }
        }
        return new ArrayList<>(set);
    }


    public static void main(String[] args){
        PowerfulIntegers powerfulIntegers = new PowerfulIntegers();
        System.out.println(powerfulIntegers.powerfulIntegers(2,3,10));
    }
}
