import java.math.BigInteger;

/**67. 二进制求和
 给你两个二进制字符串，返回它们的和（用二进制表示）。

 输入为 非空 字符串且只包含数字 1 和 0。



 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"


 提示：

 每个字符串仅由字符 '0' 或 '1' 组成。
 1 <= a.length, b.length <= 10^4
 字符串如果不是 "0" ，就都不含前导零。*/
public class AddBinary {
    //数值溢出
    public String addBinary(String a, String b) {
        long aInt = Long.valueOf(a,2);
        long bInt = Long.valueOf(b,2);
        long noCarry = aInt^bInt;
        long carry = (aInt & bInt)<<1;
        long temp = noCarry;
        while ((noCarry&carry) != 0) {
            temp = noCarry;
            noCarry = noCarry ^ carry;
            carry = (temp & carry)<<1;
        }
        return Long.toBinaryString(noCarry|carry);
    }

    //99.04%,88.02%
    public String addBinary2(String a, String b) {
        StringBuilder stringBuilder=new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int n = Math.max(aLen,bLen);
        int carry = 0;
        for (int i=0; i<n; i++){
            if (i<aLen){
                carry += a.charAt(aLen-i-1) - '0';
            }else {
                carry += 0;
            }
            if (i<bLen){
                carry += b.charAt(bLen-i-1) - '0';
            }else {
                carry += 0;
            }
            stringBuilder.append((char)(carry%2+'0'));
            carry /= 2;
        }
        if (carry>0){
            stringBuilder.append('1');
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        AddBinary addBinary=new AddBinary();
        System.out.println(addBinary.addBinary("101","111"));
        System.out.println(addBinary.addBinary("11","1"));
        System.out.println(addBinary.addBinary("1010","1011"));
    }
}
