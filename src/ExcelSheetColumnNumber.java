/**171. Excel表列序号
 给定一个Excel表格中的列名称，返回其相应的列序号。

 例如，

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 示例 1:

 输入: "A"
 输出: 1
 示例 2:

 输入: "AB"
 输出: 28
 示例 3:

 输入: "ZY"
 输出: 701
 致谢：
 特别感谢 @ts 添加此问题并创建所有测试用例。*/
public class ExcelSheetColumnNumber {
    //38.02%,6.61%
    public int titleToNumber(String s) {
        int len = s.length();
        if (len == 1){
            return (int)(s.charAt(0)-'A')+1;
        }
        int num = 0;
        for (char ch : s.toCharArray()){
            num += ((int)(ch-'A')+1)*Math.pow(26,len-1);
            len--;
        }
        return num;
    }

    //优秀解答
    public int titleToNumber2(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }


}
