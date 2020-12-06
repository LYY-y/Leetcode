/**367. 有效的完全平方数
 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

 说明：不要使用任何内置的库函数，如  sqrt。

 示例 1：

 输入：16
 输出：True
 示例 2：

 输入：14
 输出：False*/
public class ValidPerfectSquare {
    //100.00%,99.71%
    public boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;
        while (low<=high){
            long mid = (high-low)/2+low;
            long power = mid*mid;
            if (power==num){
                return true;
            }else if (power > num){
                high = mid-1;
            }else if (power < num){
                low = mid+1;
            }
        }
        return false;
    }


    //牛顿迭代法
    public boolean isPerfectSquare2(int num) {
        if (num < 2) return true;

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }


    public static void main(String[] args){
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(16));
    }
}
