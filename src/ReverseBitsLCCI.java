/**面试题 05.03. 翻转数位
 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

 示例 1：

 输入: num = 1775(110111011112)
 输出: 8
 示例 2：

 输入: num = 7(01112)
 输出: 4*/
public class ReverseBitsLCCI {
    //100.00%,88.17%
    public int reverseBits(int num) {
        int maxLen = 0;
        int curLen = 0;
        int preLen = 0;
        int count = 32;
        while (num != 0 && count > 0){
            if ((num&1) == 1){
                curLen++;
            }else {
                preLen = curLen;
                curLen = 0;
            }
            maxLen = Math.max(maxLen, curLen+preLen);
            num = num >> 1;
            count--;
        }
        if (maxLen == 32){
            return 32;
        }
        return maxLen+1;
    }

    public static void main(String[] args){
        ReverseBitsLCCI reverseBitsLCCI = new ReverseBitsLCCI();
        System.out.println(reverseBitsLCCI.reverseBits(-1));
        System.out.println(reverseBitsLCCI.reverseBits(1775));
    }
}
