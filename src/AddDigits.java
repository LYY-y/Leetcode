/**258. 各位相加
 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

 示例:

 输入: 38
 输出: 2
 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 进阶:
 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？*/
public class AddDigits {
    //100.00%,95.37%
    public int addDigits(int num) {
        if (num/10 == 0){
            return num;
        }
        int sum = 0;
        while (sum==0 || sum/10!=0) {
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return sum;
    }

    //数学法
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args){
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(38));
    }
}
