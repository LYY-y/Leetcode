/**204. 计数质数
 统计所有小于非负整数 n 的质数的数量。

 示例:

 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * */
public class CountPrimes {
    //13.71%,89.58%
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++){
            if (isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    //优秀解答
    public int countPrimes2(int n) {
            if (n <= 2) {
                return 0;
            }
            // 首先去掉一半的偶数
            int count = n / 2;
            boolean[] isPrimes = new boolean[n];
            for (int i = 3; i * i < n; i += 2) {
                // 不是质数 => continue
                if (!isPrimes[i])
                    // i 的倍数不可能是素数了
                    for (int j = i * i; j < n; j += 2 * i) {
                        if (!isPrimes[j]) {
                            // System.out.println(j + "不是质数");
                            count--;
                            isPrimes[j] = true;
                        }
                    }
            }
            return count;
        }


}
