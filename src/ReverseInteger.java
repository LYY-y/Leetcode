//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。注意:
//
//        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/reverse-integer
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//难点：解决溢出问题！！！
public class ReverseInteger {
    public int reverse(int x) {
        int result=0;
        int digit = checkDigit(x);
        if (digit>1) {
            int first = x / (int) Math.pow(10, digit - 1);
            int removeFirst = x % (int) Math.pow(10, digit - 1);

            for (int i = digit - 2; i >= 0; i--) {
                result = result + (removeFirst % 10) * (int) Math.pow(10, i);
                removeFirst = removeFirst / 10;
                if (x >= 0) {
                    if (result > Integer.MAX_VALUE / 10) {
                        return 0;
                    }
                }else {
                    if (result < Integer.MIN_VALUE / 10) {
                        return 0;
                    }
                }
            }
            result = result * 10 + first;
            return result;
        }else {
            return x;
        }
    }

    public int checkDigit(int x){
        int digit =0;
        while (x!=0){
            x=x/10;
            digit++;
        }
        return digit;
    }


    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-123));
    }

    public int reverseAnswer(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {   //若溢出则不会相等
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
    public int reverseAnswerB(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

//    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
