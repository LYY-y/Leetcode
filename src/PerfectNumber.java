/**507. 完美数
 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。

 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false



 示例 1：

 输入：28
 输出：True
 解释：28 = 1 + 2 + 4 + 7 + 14
 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 示例 2：

 输入：num = 6
 输出：true
 示例 3：

 输入：num = 496
 输出：true
 示例 4：

 输入：num = 8128
 输出：true
 示例 5：

 输入：num = 2
 输出：false


 提示：

 1 <= num <= 108*/
public class PerfectNumber {
    //6.55%,95.46%
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i=1;; i++){
            if (num%i==0){
                int k = num/i;
                if (i==k){
                    sum += i;
                    break;
                }
                if (i>k){
                    break;
                }
                sum += i;
                sum += k;
            }
        }
        return sum-num==num;
    }

    //欧几里得-欧拉定理,目前仅发现偶完全数，奇完全数未发现
    public int pn(int p) {  //p是梅林素数
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    public boolean checkPerfectNumber2(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }

    //优秀解答
    public boolean checkPerfectNumber3(int num) {
        if(num == 1)
            return false;
        int sum = 1;
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                sum += i;
                sum += num/i;
            }
        }
        return sum == num ? true : false;
    }


    public static void main(String[] args){
        PerfectNumber perfectNumber=new PerfectNumber();
        System.out.println(perfectNumber.checkPerfectNumber(28));
    }
}
