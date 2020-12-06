import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**762. 二进制表示中质数个计算置位
 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。

 （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）

 示例 1:

 输入: L = 6, R = 10
 输出: 4
 解释:
 6 -> 110 (2 个计算置位，2 是质数)
 7 -> 111 (3 个计算置位，3 是质数)
 9 -> 1001 (2 个计算置位，2 是质数)
 10-> 1010 (2 个计算置位，2 是质数)
 示例 2:

 输入: L = 10, R = 15
 输出: 5
 解释:
 10 -> 1010 (2 个计算置位, 2 是质数)
 11 -> 1011 (3 个计算置位, 3 是质数)
 12 -> 1100 (2 个计算置位, 2 是质数)
 13 -> 1101 (3 个计算置位, 3 是质数)
 14 -> 1110 (3 个计算置位, 3 是质数)
 15 -> 1111 (4 个计算置位, 4 不是质数)
 注意:

 L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 R - L 的最大值为 10000。*/
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    //33.39%,12.10%
    public int countPrimeSetBits(int L, int R) {
        Integer[] primes = new Integer[]{2,3,5,7,11,13,17,19};
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(primes));
        int count = 0;
        for (int i = L; i<=R; i++){
            if (set.contains(countBits(i))){
                count++;
            }
        }
        return count;
    }

    public int countBits(int k){
        int c = 0;
        while (k > 0 ){
            c++;
            k = k&(k-1);
        }
        return c;
    }

    //优秀解答：将 1 ~ 19 中的是否为质数的关系编码到二进制中。
//                  19  18  17  16  15  14  13  12  11  10  9  8  7  6  5  4  3  2  1  0
//       665772 = ( 1   0   1   0   0   0   1   0   1   0   0  0  1  0  1  0  1  1  0  0 )
    public int countPrimeSetBits2(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int x = 665772 >> Integer.bitCount(i);
            String p = Integer.toBinaryString(665772);
            String k = Integer.toBinaryString(x);
            int y =  x&1;
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;
    }

    public static void main(String[] args){
        PrimeNumberOfSetBitsInBinaryRepresentation primeNumberOfSetBitsInBinaryRepresentation = new PrimeNumberOfSetBitsInBinaryRepresentation();
        System.out.println(primeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits2(6,10));
        System.out.println(primeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(10,15));

    }
}
