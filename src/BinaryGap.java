/**868. 二进制间距
 给定一个正整数 N，找到并返回 N 的二进制表示中两个相邻 1 之间的最长距离。

 如果没有两个相邻的 1，返回 0 。



 示例 1：

 输入：22
 输出：2
 解释：
 22 的二进制是 0b10110 。
 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 答案取两个距离之中最大的，也就是 2 。
 示例 2：

 输入：5
 输出：2
 解释：
 5 的二进制是 0b101 。
 示例 3：

 输入：6
 输出：1
 解释：
 6 的二进制是 0b110 。
 示例 4：

 输入：8
 输出：0
 解释：
 8 的二进制是 0b1000 。
 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。


 提示：

 1 <= N <= 10^9*/
public class BinaryGap {
    //89.02%,74.94%
    public int binaryGap(int n) {
        int maxLen = 0;
        boolean isOne = false;
        int len = 0;
        while (n>0){
            if ((n&1)==1){
                if (isOne){
                    maxLen = Math.max(maxLen,len);
                    len = 0;
                }else {
                    isOne = true;
                }
            }
            if (isOne){
                len++;
            }
            n=n>>1;
        }
        return maxLen;
    }

    //记录索引
    public int binaryGap2(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }

    //一次遍历
    public int binaryGap3(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }

    //优秀解答100%
    public int binaryGap4(int N) {
        int res=0;
        int tmp=0;
        while((N&1)!=1)N>>=1;//先找到第一个1
        while(N>0){
            if((N&1)==1){
                res=tmp>res?tmp:res;//更新结果
                tmp=0;
            }
            tmp++;
            N>>=1;
        }
        return res;
    }

    public static void main(String[]args){
        BinaryGap binaryGap=new BinaryGap();
        System.out.println(binaryGap.binaryGap(22));
        System.out.println(binaryGap.binaryGap(5));
        System.out.println(binaryGap.binaryGap(6));
        System.out.println(binaryGap.binaryGap(8));

    }
}
