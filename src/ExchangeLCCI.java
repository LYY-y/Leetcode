/**面试题 05.07. 配对交换
 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。

 示例1:

 输入：num = 2（或者0b10）
 输出 1 (或者 0b01)
 示例2:

 输入：num = 3
 输出：3
 提示:

 num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。*/
public class ExchangeLCCI {
    public int exchangeBits(int num) {
        if (num == 1){
            return 1;
        }
        String binaryStr = Integer.toBinaryString(num);
        String exchangeStr = "";
        for (int i=binaryStr.length()-1; i-1>=0;i=i-2){
            exchangeStr = binaryStr.charAt(i-1)+exchangeStr;
            exchangeStr = binaryStr.charAt(i)+exchangeStr;
        }
        String binaryStr2 = Integer.toBinaryString(788947819);
        return Integer.parseInt(exchangeStr,2);
    }

    //优秀解答
    public int exchangeBits2(int num) {
        //奇数
        int odd = num & 0x55555555;
        //偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;
    }

    public static void main(String[] args){
        ExchangeLCCI exchangeLCCI = new ExchangeLCCI();
        System.out.println(exchangeLCCI.exchangeBits(520721303));

        System.out.println(exchangeLCCI.exchangeBits(2));
        System.out.println(exchangeLCCI.exchangeBits(3));
    }
}
