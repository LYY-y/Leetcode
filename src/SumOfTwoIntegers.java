/**371. 两整数之和
 不使用运算符 + 和 - ，计算两整数a 、b之和。

 示例 1:

 输入: a = 1, b = 2
 输出: 3
 示例 2:

 输入: a = -2, b = 3
 输出: 1*/
public class SumOfTwoIntegers {
    //100.00%,37.38%
    public int getSum(int a, int b) {
        while (b != 0){
            int sum = a^b;
            int carry = (a&b)<<1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
