import java.util.Arrays;

/**1175. 质数排列
 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。

 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。

 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。



 示例 1：

 输入：n = 5
 输出：12
 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 示例 2：

 输入：n = 100
 输出：682289015


 提示：

 1 <= n <= 100*/
public class PrimeArrangements {
    //55.06%,100.00%
    public int numPrimeArrangements(int n) {
        boolean[] primes = isPrimes(n);
        int primeCount = 0;
        for (int i=2; i<n+1; i++){
            if (primes[i]){
                primeCount++;
            }
        }
        long res = 1;
        for (int j=primeCount; j>0; j--){
            if(res<1000000007/j){
                res*=j;
            }
            else {
                res = res * j % 1000000007;
            }
        }
        for (int k=n-primeCount; k>0; k--){
            if(res<1000000007/k){
                res*=k;
            }
            else {
                res = res * k % 1000000007;
            }
        }
        return (int) res;
    }

    public boolean[] isPrimes(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        for (int i=2; i*i<n+1; i++){
            if (primes[i]){
                for (int j=i*i;j<n+1;j=j+i){
                    primes[j]=false;
                }
            }
        }
        return primes;
    }


    //优秀解答
    public int numPrimeArrangements2(int n) {
        int[] zhishu={
                2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,
                83,89,97
        };
        //计算质数个数
        int nzhishu=0;
        for(int c:zhishu){
            if(n>=c){
                nzhishu++;
            }
        }
        //计算非质数的个数
        int nfeizhishu=n-nzhishu;
        long ans=1;
        for(int i=nfeizhishu;i>1;i--){
            if(ans<1000000007/i){
                ans*=i;
            }
            else{
                ans=ans*i%1000000007;
            }
        }
        for(int i=nzhishu;i>1;i--){
            if(ans<1000000007/i){
                ans*=i;
            }
            else{
                ans=ans*i%1000000007;
            }
        }
        return (int)ans%1000000007;
    }

    public static void main(String[] args){
        PrimeArrangements primeArrangements=new PrimeArrangements();
        System.out.println(primeArrangements.numPrimeArrangements(5));
    }
}
