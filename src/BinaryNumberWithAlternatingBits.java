/**693. 交替位二进制数
 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

 示例 1:

 输入: 5
 输出: True
 解释:
 5的二进制数是: 101
 示例 2:

 输入: 7
 输出: False
 解释:
 7的二进制数是: 111
 示例 3:

 输入: 11
 输出: False
 解释:
 11的二进制数是: 1011
 示例 4:

 输入: 10
 输出: True
 解释:
 10的二进制数是: 1010*/
public class BinaryNumberWithAlternatingBits {
    //100.00%，50.15%
    public boolean hasAlternatingBits(int n) {
        if (n < 3){
            return true;
        }
        int bit = n&1;
        n = n>>1;
        while (n>0){
            if (bit == 0 && (n&1)==0){
                n=n>>1;
                bit = n&1;
                return false;
            }
            if (bit == 1 && (n&1)==1){
                n=n>>1;
                bit = n&1;
                return false;
            }
            bit = n&1;
            n=n>>1;
        }
        return true;
    }

    //优秀解答
    public boolean hasAlternatingBits2(int n) {
        int tail = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == tail) {
                return false;
            }
            tail = n & 1;
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args){
        BinaryNumberWithAlternatingBits binaryNumberWithAlternatingBits = new BinaryNumberWithAlternatingBits();
        System.out.println(binaryNumberWithAlternatingBits.hasAlternatingBits(5));
    }
}

