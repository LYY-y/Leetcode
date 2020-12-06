/**面试题 05.06. 整数转换
 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。

 示例1:

 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 输出：2
 示例2:

 输入：A = 1，B = 2
 输出：2
 提示:

 A，B范围在[-2147483648, 2147483647]之间
 通过次数5,282提交次数10,452
 在真实的面试中遇到过这道题？
 /34

 智能模式
 连接失败，点击重试
 模拟面试






 12345
 class Solution {
 public int convertInteger(int A, int B) {

 }
 }
 控制台
 贡献
 请输入...( 支持使用 Markdown )
 ​
 已保存
 搜索题目



 未做
 简单
 树
 该列表为空*/
public class ConvertIntegerLCCI {
    //100.00%,62.25%
    public int convertInteger(int A, int B) {
        int diff = A^B;
        int count = 0;
        while (diff != 0){
            count++;
            diff = diff&(diff-1);
        }
        return count;
    }
}
