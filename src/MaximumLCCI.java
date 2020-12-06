/**面试题 16.07. 最大数值
 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

 示例：

 输入： a = 1, b = 2
 输出： 2*/
public class MaximumLCCI {
    //100.00%,43.07%
    public int maximum(int a, int b) {
        long difference = (long)a - (long)b;
        int k = (int)(difference>>63);  //由于是long型，右移63位得到符号位，注意负号不变，那么正数右移63位就是0，负数右移63位就是-1
//        当 x >= 0 的时候，k = 0, 即 a > b
//        那么我们的计算公式为 1 * a - b * 0 = a
//
//        当 x < 0的时候，k = -1, 即 b > a
//        那么我们的计算公式为 0 * a - b * ( -1 ) = b
        return  (1 + k) * a - b * k;
    }

    //优秀解答
    public int maximum2(int a, int b) {
        long c = a;
        long d = b;
        return (int)((Math.abs(c-d)+c+d)/2);
    }
}
