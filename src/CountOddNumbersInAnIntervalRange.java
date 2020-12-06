/**1523. 在区间范围内统计奇数数目
 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。



 示例 1：

 输入：low = 3, high = 7
 输出：3
 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 示例 2：

 输入：low = 8, high = 10
 输出：1
 解释：8 到 10 之间奇数数字为 [9] 。


 提示：

 0 <= low <= high <= 10^9*/
public class CountOddNumbersInAnIntervalRange {
    //5.02%,56.10%
    public int countOdds(int low, int high) {
        int count = 0;
        for (int i=low; i<=high; i++){
            if ((i&1)==1){
                count++;
            }
        }
        return count;
    }

    //优秀解答
    public int countOdds2(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public int pre(int x) {
        return (x + 1) >> 1;
    }

    public int countOdds3(int low, int high) {
        if(low%2==0){
            return count(high)-count(low);
        }else{
            return count(high)-count(low)+1;
        }
    }
    public int count(int a){
        if(a%2==0){
            return a/2;
        }else{
            return a/2+1;
        }
    }

}
