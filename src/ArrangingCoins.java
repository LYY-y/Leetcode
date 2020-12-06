/**441. 排列硬币
 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

 给定一个数字 n，找出可形成完整阶梯行的总行数。

 n 是一个非负整数，并且在32位有符号整型的范围内。

 示例 1:

 n = 5

 硬币可排列成以下几行:
 ¤
 ¤ ¤
 ¤ ¤

 因为第三行不完整，所以返回2.
 示例 2:

 n = 8

 硬币可排列成以下几行:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 因为第四行不完整，所以返回3.*/
public class ArrangingCoins {
    //二分法85.13%，99.94%
    public int arrangeCoins(int n) {
        int l = 0;
        int r = n;
        while (l<=r){
            long mid = (r-l)/2+l;
            long coins = needCoins(mid);
            if (coins == n){
                return (int)mid;
            }else if (coins > n){
                r = (int)mid -1;
            }else if (coins < n){
                l = (int)mid+1;
            }

        }
        return r;
    }

    public long needCoins(long row){
        return (1+row)*row/2;
    }

    //优秀解答，等差数列求和，一元二次方程，结果取整。
    public int arrangeCoins2(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public static void main(String[] args){
        ArrangingCoins arrangingCoins=new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(5));
    }
}
